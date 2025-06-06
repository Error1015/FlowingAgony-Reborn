package love.marblegate.flowingagonyreborn.item

import net.minecraft.world.item.EnchantedBookItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentInstance

/**
 * 暂时作为LOGO使用
 */
open class FlowingAgonyEnchantedBookItem(properties: Properties) : EnchantedBookItem(properties) {
    override fun isFoil(pStack: ItemStack) = true
}