package love.marblegate.flowingagonyreborn.util

import love.marblegate.flowingagonyreborn.effect.implicit.ImplicitBaseEffect
import net.minecraft.world.effect.MobEffectInstance

/**
 * 设置为隐式效果
 */
val MobEffectInstance.setImplicit: MobEffectInstance
    @JvmName("implicit") get() = MobEffectInstance(
        effect, duration, amplifier, false, false
    )

/**
 * 是否为隐式效果
 */
val MobEffectInstance.isImplicit
    @JvmName("isImplicit") get() = effect is ImplicitBaseEffect || !isVisible || !showIcon()

/**
 * 是否为显示效果
 */
val MobEffectInstance.isExplicit @JvmName("isExplicit") get() = !isImplicit