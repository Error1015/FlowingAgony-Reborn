package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory

open class SimpleEffect(
    category: MobEffectCategory, color: Int
) : MobEffect(category, color)