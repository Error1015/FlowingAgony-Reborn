package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.capability.ModCapManager
import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.ModDamageTypes
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.rootedinhatred.*
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.util.getArmorEnchantmentTotalLevel
import love.marblegate.flowingagonyreborn.util.getEnchantmentLevel
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import love.marblegate.flowingagonyreborn.util.setImplicit
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object RootedInHatredEnchantmentEventHandler {
    @SubscribeEvent
    fun doResentfulSoulEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && !event.source.`is`(DamageTypes.FELL_OUT_OF_WORLD) && !event.source.`is`(ModDamageTypes.burial_object_curse)) {
            val player = event.entity as Player
            if (event.amount >= player.health) {
                val enchantmentLevel = player.getEnchantmentLevel(ResentfulSoulEnchantment, EquipmentSlot.HEAD)
                if (enchantmentLevel <= 0) return
                if (player.lastHurtMobTimestamp <= 25 + enchantmentLevel * 25) {
                    event.isCanceled = true
                }
            }
        }
    }

    @SubscribeEvent
    fun doTooResentfulToDieEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.entity != event.source.entity && !event.source.`is`(DamageTypes.FELL_OUT_OF_WORLD) && !event.source.`is`(
                    ModDamageTypes.burial_object_curse
                )) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(TooResentfulToDieEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel == 0) return
            if (event.amount >= player.health) {
                if (!player.hasEffect(ModEffects.EXTREME_HATRED)) {
                    player.heal(1f + enchantmentLevel * 3)
                    player.addEffect(MobEffectInstance(ModEffects.EXTREME_HATRED, 7200))

                    val serverPlayer = (player as? ServerPlayer) ?: return
                    Networking.safeSend(
                        PacketDistributor.PLAYER.with {
                            serverPlayer
                        }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FIRST_STAGE, true)
                    )
                    event.isCanceled = true
                } else {
                    val effectLevel = player.getEffect(ModEffects.EXTREME_HATRED)?.let { it.amplifier + 1 } ?: 0
                    when (effectLevel) {
                        1 -> {
                            player.heal(1f + enchantmentLevel * 2)
                            player.addEffect(MobEffectInstance(ModEffects.EXTREME_HATRED, 7200, 1))
                            val serverPlayer = player as? ServerPlayer ?: return
                            Networking.safeSend(PacketDistributor.PLAYER.with {
                                serverPlayer
                            }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_MEDIUM_STAGE, true))
                            event.isCanceled = true
                        }

                        2 -> {
                            player.heal(1f + enchantmentLevel)
                            player.addEffect(MobEffectInstance(ModEffects.EXTREME_HATRED, 7200, 2))
                            val serverPlayer = player as? ServerPlayer ?: return
                            Networking.safeSend(PacketDistributor.PLAYER.with {
                                serverPlayer
                            }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FINAL_STAGE, true))
                            event.isCanceled = true
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun doOutrageousSpiritEnchantmentEvent(event: LivingHurtEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(OutrageoutSpiritEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            var negativeEffectCount = 0
            if (player.isOnFire) negativeEffectCount++
            negativeEffectCount += player.activeEffects.stream().filter { it.effect.category == MobEffectCategory.HARMFUL }.count().toInt()
            event.amount += negativeEffectCount * enchantmentLevel * CommonConfig.numericalSettings.outrageousSpirit.toFloat()
        }
    }

    @SubscribeEvent
    fun doHatredBloodlikeEnchantmentEventAcvtivateHatredBloodlineMarkOnDeath(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getArmorEnchantmentTotalLevel(HatredBloodlineEnchantment)
            if (enchantmentLevel == 0) return
            val capability = player.getCapability(ModCapManager.HatredBloodlineStatus_Capability)
            capability.ifPresent { it.setActiveLevel(enchantmentLevel) }
        }
    }

    @SubscribeEvent
    fun doHatredBloodlikeEnchantmentEventActiveEnchantmentEffectWhenRespawn(event: PlayerEvent.PlayerRespawnEvent) {
        if (event.entity.level().isClientSide) return
        val capability = event.entity.getCapability(ModCapManager.HatredBloodlineStatus_Capability)
        capability.ifPresent {
            val activeLevel = it.getActiveLevel()
            if (activeLevel != 0) {
                event.entity.addEffect(
                    MobEffectInstance(
                        ModEffects.HATRED_BLOODLINE_ENCHANTMENT_ACTIVE, 800 * activeLevel, activeLevel - 1
                    ).setImplicit
                )
                it.setActiveLevel(0)
            }
        }
    }

    @SubscribeEvent
    fun doFreshRevengeEnchantmentEventApplyBuff(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(FreshRevengeEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            if (event.entity.lastHurtMobTimestamp <= 20 + enchantmentLevel * 4) {
                player.addEffect(MobEffectInstance(ModEffects.FRESH_REVENGE_ENCHANTMENT_ACTIVE, 200, enchantmentLevel - 1).setImplicit)
            }
        }
    }
}