package love.marblegate.flowingagonyreborn.util

import love.marblegate.flowingagonyreborn.effect.implicit.ImplicitBaseEffect
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance

object EffectUtil {
    fun genImplicitEffect(effect: MobEffect, duration: Int) = genImplicitEffect(effect, duration, 0)

    fun genImplicitEffect(effect: MobEffect, duration: Int, amplifier: Int) = MobEffectInstance(effect, duration, amplifier, false, false)

    fun MobEffectInstance.isImplicit() = this.effect is ImplicitBaseEffect || !this.isVisible || !this.showIcon()

    fun MobEffectInstance.isExplicit() = !isImplicit()
}