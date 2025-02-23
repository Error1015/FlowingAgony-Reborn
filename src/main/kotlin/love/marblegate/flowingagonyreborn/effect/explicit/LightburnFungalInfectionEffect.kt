package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity

object LightburnFungalInfectionEffect : MobEffect(MobEffectCategory.HARMFUL, 16777196) {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        // pLivingEntity.hurt(TODO())
    }

    override fun isDurationEffectTick(duration: Int, amplifier: Int): Boolean {
        var k = 40
        if (amplifier > 0) k /= (amplifier * amplifier)
        return if (k > 0) duration % k == 0 else false
    }
}