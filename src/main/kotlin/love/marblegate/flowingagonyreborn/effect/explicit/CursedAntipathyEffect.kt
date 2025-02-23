package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory

object CursedAntipathyEffect : MobEffect(
    MobEffectCategory.HARMFUL, 18432
) {
    /* override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        if (this == CursedAntipathyEffect) {
            // pLivingEntity.hurt(,1.0f)
            if (pLivingEntity.level().isClientSide) return
            TODO()
        }
    } */

    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean {
        val k = when (pAmplifier) {
            0 -> 100
            1 -> 80
            2 -> 60
            3 -> 40
            else -> 30
        }
        return pDuration % k == 0
    }
}