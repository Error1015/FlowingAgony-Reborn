package love.marblegate.flowingagonyreborn.item

import net.minecraft.world.item.EnchantedBookItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentInstance

/**
 * 暂时作为LOGO使用
 */
open class FlowingAgonyEnchantedBookItem(properties: Properties) : EnchantedBookItem(properties) {
    companion object {
        @JvmStatic
        fun createForFlowingAgonyEnchantment(instance: EnchantmentInstance): ItemStack {
            val stack = ItemStack(ModItems.FLOWING_AGONY_ENCHANTED_BOOK)
            stack.addEnchantment(instance)
            return stack
        }

        fun ItemStack.addEnchantment(instance: EnchantmentInstance) = addEnchantment(this, instance)
    }

    override fun isFoil(pStack: ItemStack) = true
}