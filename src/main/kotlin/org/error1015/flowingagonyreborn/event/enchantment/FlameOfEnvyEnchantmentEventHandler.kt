package org.error1015.flowingagonyreborn.event.enchantment

import net.minecraft.util.Mth
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.monster.EnderMan
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Arrow
import net.minecraft.world.entity.projectile.SpectralArrow
import net.minecraft.world.item.alchemy.Potion
import net.minecraft.world.item.alchemy.Potions
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.phys.EntityHitResult
import net.minecraftforge.event.entity.ProjectileImpactEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.util.ObfuscationReflectionHelper
import org.error1015.flowingagonyreborn.enchantment.flameofenvy.*
import org.error1015.flowingagonyreborn.util.getEnchantmentLevel
import org.error1015.flowingagonyreborn.util.getTargetsExceptOneself
import org.error1015.flowingagonyreborn.util.getTargetsOfSameType
import org.error1015.flowingagonyreborn.util.isHostile
import kotlin.math.floor
import kotlin.random.Random

@Mod.EventBusSubscriber
object FlameOfEnvyEnchantmentEventHandler {
    /**
     * 善妒之人
     */
    @SubscribeEvent
    fun doEnviousKindEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.isCanceled) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(EnviousKindEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel != 0) {
                val diff = event.entity.health - player.health
                if (diff >= 0) {
                    val amplifier = floor(diff / 10.0)
                    TODO("添加mod添加的效果") // player.addEffect(/* 效果 */,200,amplifier)
                }
            }
        }
    }

    /**
     * 眼中钉刺
     */
    @SubscribeEvent
    fun doEyesoreEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.isCanceled) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(EyesoreEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel != 0) {
                // event.entity.addEffect()
            }
        }
    }

    /**
     * 肉中荆棘
     */
    @SubscribeEvent
    fun doThornInFleshEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ThornInFleshEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel != 0) {
                if (event.entity is Player) {
                    TODO("添加自定义效果")
                } else {
                    TODO("添加自定义效果")
                }
            }
        }
    }

    /**
     * 暗箭难防
     */
    @SubscribeEvent
    fun doCovertKnifeEnchantmentEvent(event: ProjectileImpactEvent) {
        if (event.entity.level().isClientSide) return
        if (event.isCanceled) return
        if (event.rayTraceResult is EntityHitResult) {
            val entity = (event.rayTraceResult as EntityHitResult).entity
            if (entity is EnderMan) {
                val owner = event.projectile.owner ?: return
                if (owner is Player) {
                    val enchantmentLevel = owner.getEnchantmentLevel(CovertKnifeEnchantment, EquipmentSlot.MAINHAND)
                    if (enchantmentLevel == 0) return

                    val successProbability = when (enchantmentLevel) {
                        3 -> 1.0
                        2 -> 0.75
                        1 -> 0.5
                        else -> 0.0
                    }
                    if (Random.nextDouble() >= successProbability) return
                    // entity.hurt(DamageSource.playerAttack((Player) event.getProjectile().getOwner()), 9f) TODO(写法变了)
                    if (owner.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, EquipmentSlot.MAINHAND) == 1) entity.setSecondsOnFire(5)

                    when (event.projectile) {
                        is SpectralArrow -> entity.addEffect(MobEffectInstance(MobEffects.GLOWING, 200))

                        is Arrow -> {
                            val potion: Potion = ObfuscationReflectionHelper.getPrivateValue(
                                Arrow::class.java, (event.projectile as Arrow), "potion"
                            ) ?: return
                            if (potion != Potions.EMPTY) {
                                potion.effects.forEach {
                                    val duration = Mth.ceil(it.duration.toFloat() * 0.125f)
                                    entity.addEffect(MobEffectInstance(it.effect, duration, it.amplifier))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 嫉妒之源
     */
    @SubscribeEvent
    fun doSourceOfEnvyEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.isCanceled) return
        if (event.entity is Player && event.source.entity is LivingEntity) {
            val player = event.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(SourceOfEnvyEnchantment, EquipmentSlot.CHEST)
            if (enchantmentLevel == 0) return
            if (event.source.entity is Player) {
                val availableEnvySpreadTargets = player.getTargetsExceptOneself(12f, 2f) { livingEntity ->
                    livingEntity.isHostile(false)
                }
                if (availableEnvySpreadTargets.isNotEmpty()) {
                    availableEnvySpreadTargets.forEach {
                        if (Math.random() < 0.08 + 0.02 * enchantmentLevel) event.source.entity?.let { spreadTarget -> it.setLastHurtMob(spreadTarget) }
                    }
                }
            } else {
                val sourceEntity = event.source.entity as LivingEntity
                val availableEnvySpreadTargets = player.getTargetsOfSameType(12f, 2f, sourceEntity, true)
                if (availableEnvySpreadTargets.isNotEmpty()) {
                    availableEnvySpreadTargets.forEach { if (Math.random() < 0.15 + 0.05 * enchantmentLevel) it.setLastHurtMob(sourceEntity) }
                }
            }
        }
    }
}