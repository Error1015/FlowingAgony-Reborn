package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.LivingEntity

object PaperBrainImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        pLivingEntity.hurt(pLivingEntity.level().damageSources().magic(), (pLivingEntity.getRandom().nextInt(4) + 5).toFloat())
    }

    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean {
        val k = 20
        return if (pDuration > 0) {
            pDuration % k == 0
        } else false
    }
}