package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player

class ThornInFleshImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(
        pLivingEntity: LivingEntity,
        pAmplifier: Int
    ) {
        val duration: Int = pLivingEntity.getEffect(this)?.duration ?: 0
        if (duration % 60 < 10) {
            if (pLivingEntity is Player) {
                pLivingEntity.hurt(
                    pLivingEntity
                        .damageSources()
                        .thorns(pLivingEntity), 1f
                )
            } else {
                pLivingEntity.setDeltaMovement(0.0, pLivingEntity.deltaMovement.y, 0.0)
                pLivingEntity.hurtMarked = true
            }
        }
    }

    override fun isDurationEffectTick(
        duration: Int,
        amplifier: Int
    ) = true
}