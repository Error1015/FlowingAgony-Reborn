package love.marblegate.flowingagonyreborn.util

import net.minecraftforge.common.ForgeConfigSpec
import kotlin.reflect.KProperty

operator fun ForgeConfigSpec.DoubleValue.getValue(
    any: Any?,
    kProperty: KProperty<*>
) = get() ?: 0.0

operator fun ForgeConfigSpec.IntValue.getValue(
    any: Any?,
    kProperty: KProperty<*>
) = get() ?: 0

operator fun ForgeConfigSpec.BooleanValue.getValue(
    any: Any?,
    kProperty: KProperty<*>
) = get() ?: false