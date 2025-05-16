package love.marblegate.flowingagonyreborn.effect.explicit

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity

object ListenToMeSingingEffect : MobEffect(MobEffectCategory.HARMFUL, 6881280) {
    override fun applyEffectTick(
        entity: LivingEntity,
        pAmplifier: Int
    ) {
        if (entity.level().isClientSide) return
        val duration: Int = entity.getEffect(this)?.duration ?: 0
        val source = DamageSourceBuilder.causeRythmOfUniverse(
            entity
                .level()
                .registryAccess()
        )
        when {
            duration % 40 > 25 -> {
                entity.setDeltaMovement(0.0, 0.41, 0.0)
                entity.hurtMarked = true
            }

            duration % 40 > 7 -> {
                entity.setDeltaMovement(0.0, 0.0, 0.0)
                entity.hurtMarked = true
            }

            duration % 40 > 0 -> {
                entity.setDeltaMovement(0.0, -0.79, 0.0)
                entity.hurtMarked = true
            }

            duration % 40 == 0 -> {
                entity.setDeltaMovement(0.0, 0.0, 0.0)
                entity.hurtMarked = true
                var damage: Float = entity.maxHealth * 0.2f + entity.health * 0.5f
                damage = minOf(getMinDamage(pAmplifier), damage)
                damage = maxOf(getMaxDamage(pAmplifier), damage)
                entity.hurt(source, damage)
            }
        }
    }

    override fun isDurationEffectTick(
        pDuration: Int,
        pAmplifier: Int
    ) = true

    fun getMaxDamage(amplifier: Int) = if (amplifier == 0) 9f else (12 + amplifier * 2).toFloat()

    fun getMinDamage(amplifier: Int) = if (amplifier < 3) 1f else if (amplifier == 3) 2f else 3f
}