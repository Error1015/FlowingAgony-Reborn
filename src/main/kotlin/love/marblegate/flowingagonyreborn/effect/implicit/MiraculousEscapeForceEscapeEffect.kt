package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.LivingEntity

object MiraculousEscapeForceEscapeEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        val duration: Int = pLivingEntity.getEffect(this)?.duration ?: 0
        if (duration % 40 > 25) {
            pLivingEntity.setDeltaMovement(0.0, 2.0, 0.0)
        } else {
            pLivingEntity.setDeltaMovement(pLivingEntity.lookAngle.x(), duration / 12.5, pLivingEntity.lookAngle.z())
        }
        pLivingEntity.hurtMarked = true
    }

    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int) = true
}