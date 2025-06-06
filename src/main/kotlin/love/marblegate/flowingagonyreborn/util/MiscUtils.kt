package love.marblegate.flowingagonyreborn.util

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation

val String.asPath: ResourceLocation
    get() = ResourceLocation.fromNamespaceAndPath(ID, this)

fun translatableComponent(
    string: String,
    vararg args: Any
): Component = if (args.isNotEmpty()) {
    Component.translatable(string, args)
} else {
    Component.translatable(string)
}