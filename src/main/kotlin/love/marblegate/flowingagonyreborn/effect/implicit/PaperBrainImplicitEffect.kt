package love.marblegate.flowingagonyreborn.effect.implicit

import love.marblegate.flowingagonyreborn.Config
import net.minecraft.world.entity.LivingEntity

object PaperBrainImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(
        pLivingEntity: LivingEntity,
        pAmplifier: Int
    ) {
        pLivingEntity.hurt(
            pLivingEntity
                .level()
                .damageSources()
                .magic(), (pLivingEntity
                .getRandom()
                .nextInt(4) + 5).toFloat() * Config.numericalSettings.paperBrainHurtDamage.get()
        )
    }

    override fun isDurationEffectTick(
        pDuration: Int,
        pAmplifier: Int
    ): Boolean = pDuration > 0 && pDuration % 20 == 0
}