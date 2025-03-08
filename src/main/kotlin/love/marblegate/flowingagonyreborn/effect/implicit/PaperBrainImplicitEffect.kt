package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.LivingEntity

object
PaperBrainImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        pLivingEntity.hurt(DamageSource.MAGIC.bypassArmor(), (pLivingEntity.getRandom().nextInt(4) + 5).toFloat())
    }

    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean {
        val k = 20
        return if (pDuration > 0) {
            pDuration % k == 0
        } else false
    }
}