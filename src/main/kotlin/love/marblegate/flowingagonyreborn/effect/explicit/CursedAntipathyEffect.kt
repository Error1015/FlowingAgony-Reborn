package love.marblegate.flowingagonyreborn.effect.explicit

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity

object CursedAntipathyEffect : MobEffect(
    MobEffectCategory.HARMFUL, 18432
) {
    override fun applyEffectTick(
        livingEntity: LivingEntity,
        amplifier: Int
    ): Boolean {
        if (livingEntity.level().isClientSide) return false
        val cursedAntipathy = DamageSourceBuilder.causeCursedAntipathyDamage(
            livingEntity
                .level()
                .registryAccess()
        )
        livingEntity.hurt(cursedAntipathy, amplifier.toFloat() / 2)
        // Networking.safeSend(
        //     PacketDistributor.NEAR.with {
        //         PacketDistributor.TargetPoint(
        //             pLivingEntity.x, pLivingEntity.y, pLivingEntity.z, 192.0, pLivingEntity
        //                 .level()
        //                 .dimension()
        //         )
        //     }, ParticleEffectPacket(
        //         ParticleEffectPacket.MobEffectCategory.CURSED_ANTIPATHY_EFFECT, pLivingEntity.x, pLivingEntity.y + 1, pLivingEntity.z, (pAmplifier + 1) * 0.5, ((pAmplifier + 1) * 2).toDouble()
        //     )
        // )
        return true
    }


    override fun shouldApplyEffectTickThisTick(
        duration: Int,
        amplifier: Int
    ): Boolean {
        val k = when (amplifier) {
            0 -> 100
            1 -> 80
            2 -> 60
            3 -> 40
            else -> 30
        }
        return duration % k == 0
    }
}