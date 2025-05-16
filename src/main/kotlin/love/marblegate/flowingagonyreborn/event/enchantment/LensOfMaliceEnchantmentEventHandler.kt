package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.lensofmalice.*
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundWithLocationPacket
import love.marblegate.flowingagonyreborn.util.*
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor
import java.util.stream.Collectors

@Mod.EventBusSubscriber
object LensOfMaliceEnchantmentEventHandler {
    @SubscribeEvent
    fun doVengeanceEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val living = event.source.entity as LivingEntity
            val enchantmentLevel = player.getEnchantmentLevel(VengeanceEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel == 0) return
            living.addEffect(MobEffectInstance(ModEffects.CURSED_HATRED, 180, enchantmentLevel - 1))
        }
    }

    // 恶意感知
    @SubscribeEvent
    fun doPerceivedMaliceEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val living = event.source.entity as LivingEntity
            val enchantmentLevel = player.getEnchantmentLevel(PerceivedMaliceEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel <= 0) return
            if (living is Player) {
                living.addEffect(MobEffectInstance(ModEffects.CURSED_ANTIPATHY, 200, enchantmentLevel - 1))
            }
        }
    }

    @SubscribeEvent
    fun doMaliceOutbreakEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val living = event.source.entity as LivingEntity
            val enchantmentLevel = player.getEnchantmentLevel(MaliceOutbreakEnchantment, EquipmentSlot.HEAD)
            if (enchantmentLevel == 0) return
            living.knockback(0.4 * enchantmentLevel, -player.lookAngle.x, player.lookAngle.z)

            if (living.level().isClientSide) return
            Networking.safeSend(
                PacketDistributor.NEAR.with {
                    PacketDistributor.TargetPoint(
                        living.x, living.y, living.z, 192.0, living
                            .level()
                            .dimension()
                    )
                }, PlaySoundWithLocationPacket(
                    PlaySoundWithLocationPacket.ModSoundType.MALICE_OUTBREAK_KNOCKBACK_SOUND, true, living.x, living.y + living.eyeHeight, living.z
                )
            )
        }
    }

    @SubscribeEvent
    fun doInfectiousMaliceEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val living = event.source.entity as LivingEntity
            var totalLevel = player.getArmorEnchantmentTotalLevel(InfectiousMaliceEnchantment)
            if (totalLevel == 0) return
            if (living is Player) {
                living.addEffect(MobEffectInstance(ModEffects.CURSED_HATRED, 200 * totalLevel))
            } else {
                val effects = living.activeEffects
                    .stream()
                    .filter { it.effect.category == MobEffectCategory.HARMFUL }
                    .collect(Collectors.toList())
                if (effects.isEmpty()) return
                val targets = player.getTargetsOfSameType(8f, 2f, living, true)
                if (effects.size <= totalLevel) {
                    effects.forEach { effect ->
                        targets.forEach { target ->
                            target.addEffect(effect)
                        }
                    }
                } else {
                    val selectedEffect = mutableListOf<MobEffectInstance>()
                    while (totalLevel > 0) {
                        val effect = effects[player.random.nextInt(effects.size)]
                        if (effect !in selectedEffect) {
                            selectedEffect + effect
                            totalLevel--
                        }
                    }
                    selectedEffect.forEach { effect ->
                        targets.forEach { target ->
                            target.addEffect(effect)
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun doISeeYouNowEnchantmentEvent(event: LivingChangeTargetEvent) {
        if (event.entity.level().isClientSide) return
        if (event.newTarget is Player) {
            val player = event.newTarget as Player
            if (player.isItemEnchanted(ISeeYouNowEnchantment, EquipmentSlot.HEAD)) {
                event.entity.addEffect(MobEffectInstance(MobEffects.GLOWING, 6000))
            }
        }
    }

    @SubscribeEvent
    fun doBackAndFillEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player && event.entity.isHostile(false) && event.entity.isNeutral(false)) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(BackAndFillEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            if (event.entity.killCredit == event.source.entity) {
                event.entity.addEffect(MobEffectInstance(ModEffects.BACK_AND_FILL_ENCHANTMENT_ACTIVE, 100, enchantmentLevel - 1).setImplicit)
            } else {
                event.amount += enchantmentLevel + 1
            }
        }
    }
}