package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.ArmorUpEnchantment
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.MiraculousEscapeEnchantment
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.PotentialBurstEnchantment
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.StubbornStepEnchantment
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.network.packet.RemoveEffectSyncToClientPacket
import love.marblegate.flowingagonyreborn.util.getEnchantmentLevel
import love.marblegate.flowingagonyreborn.util.isItemEnchanted
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import love.marblegate.flowingagonyreborn.util.setImplicit
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingKnockBackEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object InnerPotentialEnchantmentEventHandler {
    @SubscribeEvent
    fun doStubbornStepEnchantmentEventAddKnockBackResistenceModifier(event: LivingKnockBackEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(StubbornStepEnchantment, EquipmentSlot.LEGS)
            if (enchantmentLevel == 0) return
            event.setStrength(event.getStrength())
            event.strength *= (1 - enchantmentLevel * 0.15f)
        }
    }

    @SubscribeEvent
    fun doStubbornStepEnchantmentEventCancelFloatingEffect(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            if (player.isItemEnchanted(StubbornStepEnchantment, EquipmentSlot.LEGS)) {
                if (player.hasEffect(MobEffects.LEVITATION)) {
                    player.removeEffectNoUpdate(MobEffects.LEVITATION)
                    Networking.safeSend(
                        PacketDistributor.PLAYER.with {
                        player as ServerPlayer
                    }, RemoveEffectSyncToClientPacket(MobEffects.LEVITATION))
                }
            }
        }
    }

    @SubscribeEvent
    fun doFrivolousStepEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(StubbornStepEnchantment, EquipmentSlot.LEGS)
            if (enchantmentLevel == 0) return
            when (enchantmentLevel) {
                1 -> player.addEffect(MobEffectInstance(ModEffects.FRIVOLOUS_STEP_ENCHANTMENT_ACTIVE, 200).setImplicit)
                else -> player.addEffect(MobEffectInstance(ModEffects.FRIVOLOUS_STEP_ENCHANTMENT_ACTIVE, 200, 1).setImplicit)
            }
            if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                player.removeEffectNoUpdate(MobEffects.MOVEMENT_SLOWDOWN)
                Networking.safeSend(
                    PacketDistributor.PLAYER.with {
                    player as ServerPlayer
                }, RemoveEffectSyncToClientPacket(MobEffects.MOVEMENT_SLOWDOWN))
            }
        }
    }

    @SubscribeEvent
    fun doPotentialBurstEnchantmentEventAddSpeedModifier(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide) return
        if (event.phase != TickEvent.Phase.START) return
        val enchantmentLevel = event.player.getEnchantmentLevel(PotentialBurstEnchantment, EquipmentSlot.FEET)
        if (enchantmentLevel == 0) return
        if (event.player.health <= enchantmentLevel + 3) {
            if (!(event.player.isSprinting || event.player.isSwimming || event.player.isFallFlying)) {
                if (event.player.hasEffect(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE)) {
                    val amplifier = event.player
                        .getEffect(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE)
                        ?.let { it.amplifier + 1 } ?: return
                    val nextAmplifier = minOf(amplifier, 150)
                    event.player.addEffect(MobEffectInstance(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE, 20, nextAmplifier).setImplicit)
                } else {
                    event.player.addEffect(MobEffectInstance(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE, 20))
                }
            } else {
                if (event.player.hasEffect(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE)) {
                    event.player.removeEffectNoUpdate(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE)

                    Networking.safeSend(
                        PacketDistributor.PLAYER.with {
                        event.player as ServerPlayer
                    }, RemoveEffectSyncToClientPacket(ModEffects.POTENTIAL_BURST_ENCHANTMENT_ACTIVE))
                }
            }
        }
    }

    @SubscribeEvent
    fun doMiraculousEscapeEnchantmentEventLaunch(event: LivingDamageEvent) {
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.health < 4f && player.isItemEnchanted(MiraculousEscapeEnchantment, EquipmentSlot.FEET)) {
                if (!player.hasEffect(ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE)) {
                    if ((!event.entity.level().isClientSide)) Networking.safeSend(
                        PacketDistributor.PLAYER.with {
                            player as ServerPlayer
                        }, PlaySoundPacket(PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT, true)
                    )
                    player.addEffect(MobEffectInstance(ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_FORCE_ESCAPE, 40).setImplicit)
                    player.addEffect(MobEffectInstance(ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE, 200).setImplicit)
                }
            }
        }
    }

    @SubscribeEvent
    fun doMiraculousEscapeEnchantmentEventProcessFallDamage(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (event.source.`is`(DamageTypes.FALL) || event.source.`is`(DamageTypes.CRAMMING) || event.source.`is`(DamageTypes.IN_WALL)) {
                if (player.hasEffect(ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE)) {
                    event.isCanceled = true
                }
            }
        }
    }

    @SubscribeEvent
    fun doArmorUpEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ArmorUpEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (player.health < 5 + enchantmentLevel) {
                if (player.absorptionAmount + 1 < enchantmentLevel + 5) {
                    player.absorptionAmount += CommonConfig.numericalSettings.armorUpEnchantment
                }
            }
        }
    }
}