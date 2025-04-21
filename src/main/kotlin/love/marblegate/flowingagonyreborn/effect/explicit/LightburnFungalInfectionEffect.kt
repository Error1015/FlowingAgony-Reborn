package love.marblegate.flowingagonyreborn.effect.explicit

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity

object LightburnFungalInfectionEffect : MobEffect(MobEffectCategory.HARMFUL, 16777196) {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        if (pLivingEntity.level().isClientSide) return
        val source = DamageSourceBuilder.causeLightburnFungalInfection(pLivingEntity.level().registryAccess())
        pLivingEntity.hurt(source, 3f)
    }

    override fun isDurationEffectTick(duration: Int, amplifier: Int): Boolean {
        var k = 40
        if (amplifier > 0) k /= (amplifier * amplifier)
        return duration % k == 0
    }
}