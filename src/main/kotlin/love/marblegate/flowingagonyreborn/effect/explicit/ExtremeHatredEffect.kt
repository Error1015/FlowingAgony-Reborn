package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player

object ExtremeHatredEffect : MobEffect(MobEffectCategory.HARMFUL, 16711680) {
    override fun applyEffectTick(
        pLivingEntity: LivingEntity,
        pAmplifier: Int
    ) {
        if (pLivingEntity is Player) {
            crazilyComsumeFoodLevel(pLivingEntity)
        }
    }

    override fun isDurationEffectTick(
        duration: Int,
        amplifier: Int
    ): Boolean {
        val k = 15 / (amplifier + 1)
        return duration % k == 0
    }

    fun crazilyComsumeFoodLevel(player: Player) {
        player
            .getFoodData()
            .addExhaustion(4f)
    }
}