package love.marblegate.flowingagonyreborn.effect.explicit

import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.network.packets.ParticleSyncPacket
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.neoforged.neoforge.network.PacketDistributor

object CursedAntipathyEffect : MobEffect(
    MobEffectCategory.HARMFUL, 18432
) {
    override fun applyEffectTick(
        livingEntity: LivingEntity, amplifier: Int
    ): Boolean {
        if (livingEntity.level().isClientSide) return false
        val effectLevel = amplifier + 1
        val cursedAntipathyDamageSource = DamageSourceBuilder.causeCursedAntipathyDamage(
            livingEntity.level().registryAccess()
        )
        livingEntity.hurt(cursedAntipathyDamageSource, amplifier.toFloat() / 2)
        if (livingEntity is Player) {
            PacketDistributor.sendToPlayersNear(
                livingEntity.level() as ServerLevel, null, livingEntity.x, livingEntity.y, livingEntity.z, 192.0, ParticleSyncPacket(
                    ParticleSyncPacket.MobEffectCategory.CURSED_ANTIPATHY_EFFECT, livingEntity.blockPosition(), effectLevel * 0.5f, effectLevel * 2
                )
            )
        }
        return true
    }


    override fun shouldApplyEffectTickThisTick(
        duration: Int, amplifier: Int
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