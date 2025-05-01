package love.marblegate.flowingagonyreborn.util

import love.marblegate.flowingagonyreborn.effect.implicit.ImplicitBaseEffect
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance

val MobEffectInstance.setImplicit: MobEffectInstance
    @JvmName("implicit") get() = MobEffectInstance(
        effect,
        duration,
        amplifier,
        false,
        false
    )

val MobEffectInstance.isImplicit @JvmName("isImplicit") get() = effect is ImplicitBaseEffect || !isVisible || !showIcon()

val MobEffectInstance.isExplicit @JvmName("isExplicit") get() = !isImplicit