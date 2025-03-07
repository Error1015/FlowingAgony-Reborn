package love.marblegate.flowingagonyreborn.event.effect

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.damagesource.ModDamageTypes
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.network.packet.RemoveEffectSyncToClientPacket
import love.marblegate.flowingagonyreborn.util.getTargetsExceptOneself
import love.marblegate.flowingagonyreborn.util.hasHelmet
import love.marblegate.flowingagonyreborn.util.helmet
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import love.marblegate.flowingagonyreborn.util.shouldReflectDamage
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
        if (event.entity.level().isClientSide) return
        if (event.entity.hasEffect(ModEffects.CURSED_HATRED) && event.source != DamageSourceBuilder.CURSED_HATRED) {
            val potionLevel = event.entity.getEffect(ModEffects.CURSED_HATRED)?.let { it.amplifier + 1 } ?: return
            event.entity.removeEffect(ModEffects.CURSED_HATRED)
            event.entity.hurt(DamageSourceBuilder.CURSED_HATRED, potionLevel * 2f * (if (event.entity is Player) 0.9f - 0.1f * Math.random() else 1f).toFloat())
        }
    }

    @SubscribeEvent
    fun doExtremeHatredEffectEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val potionLevel = if (player.hasEffect(ModEffects.EXTREME_HATRED)) player.getEffect(ModEffects.EXTREME_HATRED)?.let { it.amplifier + 1 } ?: return else 0
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
                event.amount *= (1 + potionLevel)
            }
        }
    }

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventApplyBurningSetPlayerOnFireIfNoHelmet(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide) return
        if (event.phase == TickEvent.Phase.START) {
            if (event.player.hasEffect(
                        ModEffects.CURSE_OF_UNDEAD
                    ) && (event.player.level().dayTime % 24000 == 12000.toLong()) && (!event.player.level().isThundering && !event.player.level().isRaining) && (event.player.level()
                            .canSeeSky(event.player.blockPosition()))) {
                if (!event.player.hasHelmet()) event.player.setSecondsOnFire(5)
            }
        }
    }

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventChangeFoodEffect(event: LivingEntityUseItemEvent.Finish) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
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

    @SubscribeEvent
    fun doCurseOfUndeadEffectEventApplyArmorDamageAmplifier(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide && event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.hasEffect(ModEffects.CURSE_OF_UNDEAD) && event.source.`is`(DamageTypes.ON_FIRE)) {
                event.amount *= 2
                if (player.hasHelmet()) player.helmet.hurtAndBreak(1, player) { }
            }
        }
    }

    @SubscribeEvent
    fun doAgonyResonanceEffectEvent(event: MobEffectEvent.Added) {
        if (event.entity.level().isClientSide) {
            // 客户端删除效果(可能指的是UI视觉效果)
            if (event.effectInstance.effect == ModEffects.AGONY_RESONANCE && event.entity.hasEffect(ModEffects.BEEN_RESONATED)) event.entity.removeEffect(ModEffects.BEEN_RESONATED)
        }
        if (event.effectInstance.effect == ModEffects.AGONY_RESONANCE) {
            if (event.entity.hasEffect(ModEffects.BEEN_RESONATED)) event.entity.removeEffect(ModEffects.BEEN_RESONATED)
            val entities = event.entity.getTargetsExceptOneself(8f, 2f) { true }
            entities.forEach { entity ->
                entity.addEffect(MobEffectInstance(ModEffects.BEEN_RESONATED, event.effectInstance.duration, event.effectInstance.amplifier))
            }
        }
    }

    @SubscribeEvent
    fun doBeenResonatedEffectEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity.hasEffect(ModEffects.BEEN_RESONATED) && event.source != DamageSourceBuilder.AGONY_RESONANCE) {
            val entities = event.entity.getTargetsExceptOneself(8f, 2f) { entity ->
                entity.hasEffect(ModEffects.AGONY_RESONANCE)
            }
            val damageIndex = event.entity.getEffect(ModEffects.BEEN_RESONATED)?.let { it.amplifier + 1 } ?: 0
            entities.forEach { entity -> entity.hurt(DamageSourceBuilder.AGONY_RESONANCE, event.amount * (0.35F + damageIndex * 0.15F)) }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventReduceDamage(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            if (player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                val effectLevel = player.getEffect(ModEffects.LET_ME_SAVOR_IT)?.let { it.amplifier + 1 } ?: 0
                event.amount = event.amount * (1 - 0.09F * effectLevel)
            }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventReflectDamage(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.shouldReflectDamage()) {
            if (event.entity.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                val effectLevel = event.entity.getEffect(ModEffects.LET_ME_SAVOR_IT)?.let { it.amplifier + 1 } ?: 0
                if (event.source.entity is LivingEntity) {
                    val entity = event.source.entity as LivingEntity
                    val letMeSavorIt = DamageSourceBuilder.causeLetMeSavorItDamage(event.entity)
                    if (!entity.hasEffect(ModEffects.LET_ME_SAVOR_IT)) entity.hurt(letMeSavorIt, effectLevel * event.amount)
                }
            }
        }
    }

    @SubscribeEvent
    fun onLetMeSavorItEffectEventCancelEffect(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide) return
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