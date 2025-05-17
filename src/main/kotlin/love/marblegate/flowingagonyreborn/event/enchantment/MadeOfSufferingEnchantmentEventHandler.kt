package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.madeofsuffering.*
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.AbnormalJoySyncPacket
import love.marblegate.flowingagonyreborn.util.getEnchantmentLevel
import love.marblegate.flowingagonyreborn.util.getTargetsExceptOneself
import love.marblegate.flowingagonyreborn.util.isHostile
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import love.marblegate.flowingagonyreborn.util.shouldReflectDamage
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor


@Mod.EventBusSubscriber
object MadeOfSufferingEnchantmentEventHandler {
    @SubscribeEvent
    fun onDrowningPhobiaEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player && event.shouldReflectDamage() && event.entity.isSwimming) {
            val enchantmentLevel = event.entity.getEnchantmentLevel(DrowningPhobiaEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel == 0) return
            dealPhobiaEffectDamage(event, MobEffects.BLINDNESS, enchantmentLevel)
        }
    }

    @SubscribeEvent
    fun onBurningPhobiaEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player && event.shouldReflectDamage()) {
            if (event.entity.isInLava || event.entity.remainingFireTicks > 0 && event.source.`is`(DamageTypes.ON_FIRE)) {
                val enchantmentLevel = event.entity.getEnchantmentLevel(BurningPhobiaEnchantment, EquipmentSlot.HEAD)
                if (enchantmentLevel == 0) return
                dealPhobiaEffectDamage(event, MobEffects.MOVEMENT_SLOWDOWN, enchantmentLevel)
            }
        }
    }

    private fun dealPhobiaEffectDamage(
        event: LivingDamageEvent,
        effect: MobEffect,
        level: Int
    ) {
        event.entity.addEffect(MobEffectInstance(effect, 500 - level * 100))
        event.entity.addEffect(MobEffectInstance(MobEffects.CONFUSION, 500 - level * 100))
        val player = event.entity as? Player ?: return
        val targets = player.getTargetsExceptOneself(12f, 2f) { entity -> entity.isHostile(false) }
        val damageSource = DamageSourceBuilder.causePhobiaDamage(event.entity)
        targets.forEach { target -> target.hurt(damageSource, event.amount * 1.5f + 0.5f * level) }
        if (event.source.entity is LivingEntity) {
            val attacker = event.source.entity as LivingEntity
            if (attacker !in targets && event.entity != attacker) {
                attacker.hurt(damageSource, event.amount * 1.5f + 0.5f * level * CommonConfig.numericalSettings.phobiaEffectDamage.get().toFloat())
            }
        }
    }

    @SubscribeEvent
    fun onPrayerOfPainEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(PrayerOfPainEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel == 0) return
            if (player.health < 4 + enchantmentLevel * 2) {
                if (player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                    if (player
                                .getEffect(ModEffects.LET_ME_SAVOR_IT)
                                ?.let { it.amplifier < 9 } == true) player.addEffect(
                        MobEffectInstance(
                            ModEffects.LET_ME_SAVOR_IT, 72000, player
                                .getEffect(ModEffects.LET_ME_SAVOR_IT)
                                ?.let { it.amplifier + 1 } ?: 0))
                } else player.addEffect(MobEffectInstance(ModEffects.LET_ME_SAVOR_IT, 72000))
            }
        }
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            if (player.hasEffect(ModEffects.LET_ME_SAVOR_IT)) {
                val effectLevel = player.getEffect(ModEffects.LET_ME_SAVOR_IT)?.amplifier ?: 0
                event.amount *= 1f - 0.09f * (effectLevel + 1f) * CommonConfig.numericalSettings.prayerOfPainEnchantment.get().toFloat()
            }
        }
    }

    @SubscribeEvent
    fun onConstrainedHeartEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ConstrainedHeartEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.source.`is`(DamageTypes.ON_FIRE) || event.source.`is`(DamageTypes.IN_WALL) || event.source.`is`(DamageTypes.CRAMMING) || event.source.`is`(DamageTypes.FALL) || event.source.`is`(
                        DamageTypes.FLY_INTO_WALL
                    ) || event.source.`is`(DamageTypes.WITHER) || event.source.`is`(DamageTypes.MAGIC) || player.hasEffect(MobEffects.POISON)) {
                grandAbnormalJoyPoint(event, enchantmentLevel)
            }
        }
    }

    @SubscribeEvent
    fun onPiercingFeverEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(PiercingFeverEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.source.isIndirect || event.source.`is`(DamageTypes.CACTUS) || event.source.`is`(DamageTypes.SWEET_BERRY_BUSH)) grandAbnormalJoyPoint(event, enchantmentLevel)
        }
    }

    @SubscribeEvent
    fun onDestructionWorshipEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity
                    .level()
                    .isClientSide()) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(DestructionWorshipEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.source.`is`(DamageTypes.MAGIC) || event.source.`is`(DamageTypes.EXPLOSION) || event.source.`is`(DamageTypes.LIGHTNING_BOLT)) {
                grandAbnormalJoyPoint(event, enchantmentLevel)
            }
        }
    }

    private fun grandAbnormalJoyPoint(
        event: LivingDamageEvent,
        level: Int
    ) {
        val pointCap = event.entity.getCapability(ModCapManager.AbnormalJoy_Capability)
        pointCap.ifPresent { cap ->
            cap.addPoint(event.amount * 0.25f * (level + 1))
            val serverPlayer = event.entity as? ServerPlayer ?: return@ifPresent
            Networking.safeSend(
                PacketDistributor.PLAYER.with { serverPlayer }, AbnormalJoySyncPacket(cap.getPoint())
            )
        }
    }
}