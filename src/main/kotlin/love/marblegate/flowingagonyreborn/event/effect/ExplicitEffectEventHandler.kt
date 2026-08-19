package love.marblegate.flowingagonyreborn.event.effect

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.DamageSourceFactory
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.network.packet.RemoveEffectSyncToClientPacket
import love.marblegate.flowingagonyreborn.util.*
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
import net.minecraftforge.event.entity.living.MobEffectEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object ExplicitEffectEventHandler {
    @SubscribeEvent
    fun doCursedHatredEffectEvent(event: LivingDamageEvent) {
        event.handleServer {
            val causeCursedHatredDamage = DamageSourceFactory.causeCursedHatredDamage(
                event.entity.level().registryAccess()
            )
            if (event.entity.hasEffect(ModEffects.CURSED_HATRED) && event.source != causeCursedHatredDamage) {
                val potionLevel = event.entity.getEffect(ModEffects.CURSED_HATRED)?.let { it.amplifier + 1 } ?: return
                event.entity.removeEffect(ModEffects.CURSED_HATRED)
                val damage = potionLevel * 2f * (if (event.entity is Player) 0.9f - 0.1f * Math.random() else 1f).toFloat()
                event.entity.hurt(causeCursedHatredDamage, damage * CommonConfig.numericalSettings.cursedHatredEffect.toFloat())
            }
        }
    }

    @SubscribeEvent
    fun doExtremeHatredEffectEvent(event: LivingDamageEvent) {
        event.handleServer {
            event.source.entity.safeClassCastAndHandle<Player> { player ->
                val player = event.source.entity as Player
                val potionLevel = player.getEffect(ModEffects.EXTREME_HATRED)?.let { it.amplifier + 1 } ?: return
                if (event.amount * (1 + potionLevel) >= event.entity.maxHealth) {
                    player.removeEffect(ModEffects.EXTREME_HATRED)

                    val serverPlayer = event.source.entity as? ServerPlayer ?: return
                    Networking.safeSend(PacketDistributor.PLAYER.with {
                        serverPlayer
                    }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FIRST_STAGE, false))

                    Networking.safeSend(PacketDistributor.PLAYER.with {
                        serverPlayer
                    }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_MEDIUM_STAGE, false))

                    Networking.safeSend(PacketDistributor.PLAYER.with {
                        serverPlayer
                    }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FINAL_STAGE, false))
                    event.amount *= (1 + potionLevel) * CommonConfig.numericalSettings.extremeHatredEffect.toFloat()
                }
            }
        }
    }

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventApplyBurningSetPlayerOnFireIfNoHelmet(event: TickEvent.PlayerTickEvent) {
        event.handleServer {
            if (event.phase == TickEvent.Phase.START) {
                if (event.player.hasEffect(
                            ModEffects.CURSE_OF_UNDEAD
                        ) && (event.player.level().dayTime % 24000 == 12000.toLong()) && (!event.player.level().isThundering && !event.player.level().isRaining) && (event.player
                            .level().canSeeSky(event.player.blockPosition()))) {
                    if (!event.player.hasHelmet()) {
                        event.player.setSecondsOnFire(5)
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventChangeFoodEffect(event: LivingEntityUseItemEvent.Finish) {
        if (event.entity.level().isClientSide) return

        event.handleServer {
            event.entity.safeClassCastAndHandle<Player> { player ->
                if (event.item == Items.ROTTEN_FLESH.defaultInstance) {
                    if (player.hasEffect(ModEffects.CURSE_OF_UNDEAD)) {
                        player.heal(1f)
                        player.addEffect(MobEffectInstance(MobEffects.DAMAGE_BOOST, 60))
                    }
                } else if (event.item == Items.ENCHANTED_GOLDEN_APPLE.defaultInstance && player.hasEffect(ModEffects.CURSE_OF_UNDEAD)) {
                    player.removeEffect(ModEffects.CURSE_OF_UNDEAD)
                    val serverPlayer = event.entity as? ServerPlayer ?: return
                    Networking.safeSend(
                        PacketDistributor.PLAYER.with {
                            serverPlayer
                        }, RemoveEffectSyncToClientPacket(ModEffects.CURSE_OF_UNDEAD)
                    )
                }
            }
        }
    }

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventApplyArmorDamageAmplifier(event: LivingDamageEvent) {
        event.handleServer {
            event.entity.safeClassCastAndHandle<Player> { player ->
                if (player.hasEffect(ModEffects.CURSE_OF_UNDEAD) && event.source.`is`(DamageTypes.ON_FIRE)) {
                    event.amount *= 2 * CommonConfig.numericalSettings.curseOfUndeadEffect.toFloat()
                    if (player.hasHelmet()) {
                        player.helmet.hurtAndBreak(1, player) { }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun doAgonyResonanceEffectEvent(event: MobEffectEvent.Added) {
        event.handleClient {
            // 客户端删除效果(可能指的是UI视觉效果)
            if (event.effectInstance.effect == ModEffects.AGONY_RESONANCE && event.entity.hasEffect(ModEffects.BEEN_RESONATED)) {
                event.entity.removeEffect(ModEffects.BEEN_RESONATED)
            }
        }

        event.handleServer {
            if (event.effectInstance.effect == ModEffects.AGONY_RESONANCE) {
                if (event.entity.hasEffect(ModEffects.BEEN_RESONATED)) {
                    event.entity.removeEffect(ModEffects.BEEN_RESONATED)
                }
                val entities = event.entity.getTargetsExceptOneself(8f, 2f) { true }
                entities.forEach { entity ->
                    entity.addEffect(
                        MobEffectInstance(
                            ModEffects.BEEN_RESONATED, event.effectInstance.duration, event.effectInstance.amplifier
                        )
                    )
                }
            }
        }
    }

    @SubscribeEvent
    fun doBeenResonatedEffectEvent(event: LivingDamageEvent) {
        event.handleServer {
            val source = DamageSourceFactory.causeAgonyResonance(
                event.entity.level().registryAccess()
            )
            if (event.entity.hasEffect(ModEffects.BEEN_RESONATED) && event.source != source) {
                val entities = event.entity.getTargetsExceptOneself(8f, 2f) { entity ->
                    entity.hasEffect(ModEffects.AGONY_RESONANCE)
                }
                val damageIndex = event.entity.getEffect(ModEffects.BEEN_RESONATED)?.let { it.amplifier + 1 } ?: 0
                entities.forEach { entity ->
                    entity.hurt(source, event.amount * (0.35F + damageIndex * 0.15F) * CommonConfig.numericalSettings.beenResonatedEffect.toFloat())
                }
            }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventReduceDamage(event: LivingDamageEvent) {
        event.handleServer {
            event.source.entity.safeClassCastAndHandle<Player> { player ->
                if (player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                    val effectLevel = player.getEffect(ModEffects.LET_ME_SAVOR_IT)?.let { it.amplifier + 1 } ?: 0
                    event.amount = event.amount * (1 - 0.09F * effectLevel) * CommonConfig.numericalSettings.letMeSavorItEffectReduceDamage.toFloat()
                }
            }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventReflectDamage(event: LivingDamageEvent) {
        event.handleServer {
            val letMeSavorIt = DamageSourceFactory.causeLetMeSavorItDamage(event.entity)
            event.entity.safeClassCastAndHandle<Player> { player ->
                if (event.shouldReflectDamage() && player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                    val effectLevel = event.entity.getEffect(ModEffects.LET_ME_SAVOR_IT)?.let { it.amplifier + 1 } ?: 0
                    event.source.entity.safeClassCastAndHandle<LivingEntity> { livingEntity ->
                        if (!livingEntity.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                            livingEntity.hurt(
                                letMeSavorIt,
                                effectLevel * event.amount * CommonConfig.numericalSettings.letMeSavorItEffectReflectDamage.toFloat()
                            )
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventCancelEffect(event: TickEvent.PlayerTickEvent) {
        event.handleServer {
            if (event.phase != TickEvent.Phase.START) return
            if (event.player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                if (event.player.health > 12) {
                    event.player.removeEffectNoUpdate(ModEffects.LET_ME_SAVOR_IT)
                    val serverPlayer = event.player as? ServerPlayer ?: return
                    Networking.safeSend(PacketDistributor.PLAYER.with {
                        serverPlayer
                    }, RemoveEffectSyncToClientPacket(ModEffects.LET_ME_SAVOR_IT))
                }
            }
        }
    }
}