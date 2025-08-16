package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.Level


object EyesoreImplicitEffect : ImplicitBaseEffect() {
    override fun applyEffectTick(
        entity: LivingEntity, amplifier: Int
    ) {
        entity.level().explode(entity, entity.x, entity.y, entity.z, 1f, Level.ExplosionInteraction.NONE)
        entity.hurt(
            entity.level().damageSources().explosion(entity, entity), (3 + amplifier * 2).toFloat()
        )
        entity.addEffect(MobEffectInstance(MobEffects.BLINDNESS, 60 + 20 * amplifier))
        entity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60 + 20 * amplifier))
    }

    override fun isDurationEffectTick(
        duration: Int, amplifier: Int
    ) = duration == 1
}