package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.CovertKnifeEnchantment
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.EnviousKindEnchantment
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.EyesoreEnchantment
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.SourceOfEnvyEnchantment
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.ThornInFleshEnchantment
import love.marblegate.flowingagonyreborn.util.getEnchantmentLevel
import love.marblegate.flowingagonyreborn.util.getTargetsExceptOneself
import love.marblegate.flowingagonyreborn.util.getTargetsOfSameType
import love.marblegate.flowingagonyreborn.util.setImplicit
import love.marblegate.flowingagonyreborn.util.isHostile
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
            if (enchantmentLevel == 0) return
            val diff = event.entity.health - player.health
            if (diff <= 0) return
            val temp = floor(diff / 10.0).toInt()
            // 根据配置文件决定是否修复善妒之人给予超过10级的ENVIOUS_BEING效果的Bug
            val amplifier = if (Config.acquirableSettings.isFixEnviousKind.get()) {
                if (temp > 10) 10 else temp
            } else temp
            player.addEffect(MobEffectInstance(ModEffects.ENVIOUS_BEING, 200, amplifier))
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
            if (enchantmentLevel > 0) {
                event.entity.addEffect(MobEffectInstance(ModEffects.EYESORE_ENCHANTMENT_ACTIVE, 61, enchantmentLevel - 1).setImplicit)
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
            if (enchantmentLevel > 0) {
                if (event.entity is Player) {
                    event.entity.addEffect(
                        MobEffectInstance(
                            ModEffects.THORN_IN_FLESH_ACTIVE_FOR_PLAYER, 60 + 40 * enchantmentLevel, enchantmentLevel - 1
                        ).setImplicit
                    )
                } else {
                    event.entity.addEffect(
                        MobEffectInstance(
                            ModEffects.THORN_IN_FLESH_ACTIVE, 60 + 40 * enchantmentLevel, enchantmentLevel - 1
                        ).setImplicit
                    )
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
            val entity = (event.rayTraceResult as EntityHitResult).entity ?: return
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
                    entity.hurt(owner.damageSources().playerAttack(owner), 9f)
                    if (owner.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, EquipmentSlot.MAINHAND) == 1) entity.setSecondsOnFire(5)

                    when (event.projectile) {
                        is SpectralArrow -> entity.addEffect(MobEffectInstance(MobEffects.GLOWING, 200))

                        is Arrow -> {
                            val potion: Potion = try {
                                ObfuscationReflectionHelper.getPrivateValue(
                                    Arrow::class.java, (event.projectile as Arrow), "potion"
                                ) ?: return
                            } catch (exception: Exception) {
                                exception.printStackTrace()
                                null
                            } ?: return
                            if (potion != Potions.EMPTY) {
                                potion.effects.forEach {
                                    if (it != null) {
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
                        if (Math.random() < 0.08 + 0.02 * enchantmentLevel) {
                            event.source.entity?.let { spreadTarget ->
                                it.setLastHurtMob(spreadTarget)
                            }
                        }
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