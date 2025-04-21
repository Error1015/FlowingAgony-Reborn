package love.marblegate.flowingagonyreborn.effect.explicit

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.damagesource.ModDamageTypes
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.ParticleEffectPacket
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraftforge.network.PacketDistributor

object CursedAntipathyEffect : MobEffect(
    MobEffectCategory.HARMFUL, 18432
) {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        if (pLivingEntity.level().isClientSide) return
        val cursedAntipathy = DamageSourceBuilder.causeCursedAntipathyDamage(pLivingEntity.level().registryAccess())
        pLivingEntity.hurt(cursedAntipathy, pAmplifier.toFloat() / 2)
        Networking.safeSend(
            PacketDistributor.NEAR.with {
                PacketDistributor.TargetPoint(pLivingEntity.x, pLivingEntity.y, pLivingEntity.z, 192.0, pLivingEntity.level().dimension())
            }, ParticleEffectPacket(
                ParticleEffectPacket.MobEffectCategory.CURSED_ANTIPATHY_EFFECT, pLivingEntity.x, pLivingEntity.y + 1, pLivingEntity.z, (pAmplifier + 1) * 0.5, ((pAmplifier + 1) * 2).toDouble()
            )
        )
    }

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