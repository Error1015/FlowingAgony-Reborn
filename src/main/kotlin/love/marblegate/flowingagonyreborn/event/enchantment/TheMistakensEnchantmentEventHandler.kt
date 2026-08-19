package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.DamageSourceFactory
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.themistakens.*
import love.marblegate.flowingagonyreborn.enchantment.themistakens.curse.BurialObjectCurse
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.RemoveEffectSyncToClientPacket
import love.marblegate.flowingagonyreborn.util.*
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.boss.wither.WitherBoss
import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items
import net.minecraft.world.phys.AABB
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.event.entity.living.MobEffectEvent
import net.minecraftforge.event.entity.player.PlayerXpEvent
import net.minecraftforge.eventbus.api.Event
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor
import java.util.stream.Collectors
import kotlin.math.max
import kotlin.math.min


@Mod.EventBusSubscriber
object TheMistakensEnchantmentEventHandler {
    @SubscribeEvent
    fun doShadowbornEnchantmentEventApplyAndRemoveEffect(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide) return
        if (event.phase == TickEvent.Phase.START) {
            if (event.player.hasEffect(MobEffects.BLINDNESS) && event.player.level()
                        .getMaxLocalRawBrightness(BlockPos(event.player.blockPosition())) >= 5 && event.player.isItemEnchanted(
                        ShadowbornEnchantment, EquipmentSlot.HEAD
                    )) {
                event.player.removeEffectNoUpdate(MobEffects.BLINDNESS)
                Networking.safeSend(
                    PacketDistributor.PLAYER.with { event.player as ServerPlayer },
                    RemoveEffectSyncToClientPacket(MobEffects.BLINDNESS)
                )
            }
            if (event.player.level().getMaxLocalRawBrightness(BlockPos(event.player.blockPosition())) <= 5 && event.player.isItemEnchanted(
                        ShadowbornEnchantment,
                        EquipmentSlot.HEAD
                    )) {
                if (!event.player.hasEffect(MobEffects.NIGHT_VISION)) event.player.addEffect(MobEffectInstance(MobEffects.NIGHT_VISION, 1200))
            }
        }
    }

    @SubscribeEvent
    fun doShadowBornEnchantmentEventAddImmunity(event: MobEffectEvent.Applicable) {
        if (event.entity.level().isClientSide && event.result == Event.Result.DENY) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.isItemEnchanted(ShadowbornEnchantment, EquipmentSlot.HEAD)) {
                if (player.level().getMaxLocalRawBrightness(BlockPos(event.entity.blockPosition())) >= 5) {
                    if (event.effectInstance.effect == MobEffects.BLINDNESS) event.result = Event.Result.DENY
                }
            }
        }
    }

    @SubscribeEvent
    fun doPrototypeChaoticEnchantmentEvent(event: MobEffectEvent.Added) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantLevel = player.getEnchantmentLevel(PrototypeChaoticEnchantment, EquipmentSlot.CHEST)
            if (enchantLevel == 0) return
            if (event.effectInstance.isExplicit) {
                if (player.hasEffect(ModEffects.PROTOTYPE_CHAOTIC_ENCHANTMENT_ACTIVE)) {
                    val newEffectAmplifier = min(
                        player.getEffect(ModEffects.PROTOTYPE_CHAOTIC_ENCHANTMENT_ACTIVE)
                                                     ?.let { it.amplifier + enchantLevel } ?: return, 29)
                    player.addEffect(MobEffectInstance(ModEffects.PROTOTYPE_CHAOTIC_ENCHANTMENT_ACTIVE, 1200, newEffectAmplifier).setImplicit)
                } else {
                    player.addEffect(MobEffectInstance(ModEffects.PROTOTYPE_CHAOTIC_ENCHANTMENT_ACTIVE, 1200, enchantLevel - 1).setImplicit)
                }
            }
        }
    }

    @SubscribeEvent
    fun doPrototypeChaoticTypeBetaEnchantmentEvent(event: MobEffectEvent.Added) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.isItemEnchanted(PrototypeChaoticTypeBetaEnchantment, EquipmentSlot.CHEST) && event.effectInstance.isExplicit) {
                if (event.effectInstance.effect.category == MobEffectCategory.BENEFICIAL && !event.effectInstance.effect.isInstantenous) {
                    if (player.isItemEnchanted(PrototypeChaoticEnchantment, EquipmentSlot.CHEST)) {
                        event.effectInstance.update(MobEffectInstance(event.effectInstance.effect, event.effectInstance.duration * 3))
                        val negativeEffects = player.activeEffects.stream()
                            .filter { it.effect.category == MobEffectCategory.HARMFUL && it.isCurativeItem(Items.MILK_BUCKET.defaultInstance) && it.isExplicit }
                            .collect(Collectors.toList())
                        if (negativeEffects.isNotEmpty()) {
                            negativeEffects.forEach { effect ->
                                player.removeEffect(effect.effect)
                                Networking.safeSend(PacketDistributor.PLAYER.with {
                                    event.entity as ServerPlayer
                                }, RemoveEffectSyncToClientPacket(effect.effect))
                            }
                        }
                    } else {
                        event.effectInstance.update(MobEffectInstance(event.effectInstance.effect, event.effectInstance.duration * 2))
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun doCorruptedKindredEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val living = event.source.entity as LivingEntity
            val enchantmentLevel = player.getEnchantmentLevel(CorruptedKindredEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (living.isAggresiveUndead()) {
                val random = event.entity.random
                if (random.nextInt(100) < 6 - enchantmentLevel) player.addEffect(MobEffectInstance(ModEffects.CURSE_OF_UNDEAD, 144000))
                if (living.isCommonUndead()) {
                    if (enchantmentLevel == 5) event.isCanceled = true
                    else event.amount *= 1f - (0.5f + 0.1f * enchantmentLevel)
                } else if (living.isRareUndead()) event.amount *= 1f - 0.1f * enchantmentLevel
                else if (event.source.entity is WitherBoss && enchantmentLevel > 1) event.amount *= 1f - 0.05f * (enchantmentLevel - 1)
            }
        }
    }

    @SubscribeEvent
    fun doLightburnFungalParasiticEnchantmentEventApplyProtectionAndSpreadFungalEffect(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(LightburnFungalParasiticEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.source.entity is LivingEntity) {
                val targets = if (CommonConfig.generalSettings.villagerSafeMode.get()) player.getTargetsExceptOneself(
                    8f,
                    2f
                ) { it !is Villager } else player.getTargetsExceptOneself(8f, 2f) { true }
                if (targets.isNotEmpty()) {
                    val random = player.random
                    targets.forEach {
                        if (random.nextDouble() < 0.125 * (enchantmentLevel + 1)) it.addEffect(
                            MobEffectInstance(
                                ModEffects.LIGHTBURN_FUNGAL_INFECTION,
                                120
                            )
                        )
                    }
                }
            }
            if (!event.isCanceled) {
                if (event.source.`is`(DamageTypes.FALL) || event.source.`is`(DamageTypes.EXPLOSION) || event.source.`is`(DamageTypes.ON_FIRE)) {
                    event.amount *= (1 - 0.05F * (enchantmentLevel + 1))
                }
            }
        }
    }

    @SubscribeEvent
    fun doLightburnFungalParasiticEnchantmentEventRemoveCurrentImmuneEffect(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide) return
        if (event.player.isItemEnchanted(LightburnFungalParasiticEnchantment, EquipmentSlot.CHEST)) {
            if (event.player.hasEffect(MobEffects.POISON)) {
                event.player.removeEffectNoUpdate(MobEffects.POISON)
                Networking.safeSend(PacketDistributor.PLAYER.with {
                    event.player as ServerPlayer
                }, RemoveEffectSyncToClientPacket(MobEffects.POISON))
            }

            if (event.player.hasEffect(ModEffects.LIGHTBURN_FUNGAL_INFECTION)) {
                event.player.removeEffectNoUpdate(ModEffects.LIGHTBURN_FUNGAL_INFECTION)
                Networking.safeSend(PacketDistributor.PLAYER.with {
                    event.player as ServerPlayer
                }, RemoveEffectSyncToClientPacket(ModEffects.LIGHTBURN_FUNGAL_INFECTION))
            }
        }
    }

    @SubscribeEvent
    fun doLightburnFungalParasiticEnchantmentEventAddImmunity(event: MobEffectEvent.Applicable) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.isItemEnchanted(LightburnFungalParasiticEnchantment, EquipmentSlot.CHEST)) {
                if (event.effectInstance.effect == MobEffects.POISON || event.effectInstance.effect == ModEffects.LIGHTBURN_FUNGAL_INFECTION) {
                    event.result = Event.Result.DENY
                }
            }
        }
    }

    @SubscribeEvent
    fun doScholarOfOriginalSinEnchantmentEventAddWeakness(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player && !event.source.`is`(DamageTypes.FELL_OUT_OF_WORLD)) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ScholarOfOriginalSinEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            val extraDamage = min(event.amount * (1.1f - 0.1f * enchantmentLevel), 10f)
            event.amount += extraDamage * CommonConfig.numericalSettings.scholarOfOriginalSinAddWeakness.toFloat()
        }
    }

    @SubscribeEvent
    fun doScholarOfOriginalSinEnchantmentEventExtendHarmfulEffect(event: MobEffectEvent.Added) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ScholarOfOriginalSinEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.effectInstance.effect.category == MobEffectCategory.HARMFUL && event.effectInstance.isExplicit) {
                event.effectInstance.update(
                    MobEffectInstance(
                        event.effectInstance.effect,
                        (event.effectInstance.duration * (2.1 - 0.1 * enchantmentLevel)).toInt()
                    )
                )
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun doScholarOfOriginalSinEnchantmentEventExtraEXP(event: PlayerXpEvent.PickupXp) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ScholarOfOriginalSinEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            player.giveExperiencePoints((event.orb.value * (0.35 + 0.15 * enchantmentLevel)).toInt())
        }

    }

    @SubscribeEvent
    fun doOriginalSinErosionEnchantmentEventDecreaseAttack(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(OriginalSinErosionEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            event.amount = max(event.amount - 5f + enchantmentLevel, 0f) * CommonConfig.numericalSettings.scholarOfOriginalSinDecreaseAttack.toFloat()
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun doOriginalSinErosionEnchantmentEventExtraEXP(event: PlayerXpEvent.PickupXp) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(OriginalSinErosionEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            player.giveExperiencePoints((event.orb.value * (0.05 + 0.05 * enchantmentLevel)).toInt())
        }
    }

    @SubscribeEvent
    fun doBurialObjectCurseEvent(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        val burialObjectCurseDamageSource = DamageSourceFactory.causeBurialObjectDamage(event.entity)
        if (event.entity is Player) {
            val player = event.entity as Player
            val originalDeathPos = player.blockPosition()
            val scanningArea = AABB(
                (originalDeathPos.x - 16).toDouble(),
                (originalDeathPos.y - 1).toDouble(),
                (originalDeathPos.z - 16).toDouble(),
                (originalDeathPos.x + 16).toDouble(),
                (originalDeathPos.y + 1).toDouble(),
                (originalDeathPos.z + 16.toDouble())
            )
            val players = player.level().getEntitiesOfClass(Player::class.java, scanningArea)
            players.forEach { player -> if (player.allArmorHasEnchantment(BurialObjectCurse)) player.hurt(burialObjectCurseDamageSource, 120f) }
        }
    }
}