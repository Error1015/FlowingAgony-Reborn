package love.marblegate.flowingagonyreborn.util

import love.marblegate.flowingagonyreborn.effect.implicit.ImplicitBaseEffect
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance

object EffectUtil {
    fun genImplicitEffect(effect: MobEffect, duration: Int) = genImplicitEffect(effect, duration, 0)

    fun genImplicitEffect(effect: MobEffect, duration: Int, amplifier: Int) = MobEffectInstance(effect, duration, amplifier, false, false)

    fun isImplicit(mobEffectInstance: MobEffectInstance) = mobEffectInstance.effect is ImplicitBaseEffect || !mobEffectInstance.isVisible || !mobEffectInstance.showIcon()

    fun isExplicit(mobEffectInstance: MobEffectInstance) = !isImplicit(mobEffectInstance)
}