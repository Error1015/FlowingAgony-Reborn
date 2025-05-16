package love.marblegate.flowingagonyreborn.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

abstract class ModBaseEnchantment(
    pRarity: Rarity,
    pCategory: EnchantmentCategory,
    pApplicableSlots: Array<EquipmentSlot>
) : Enchantment(pRarity, pCategory, pApplicableSlots) {
    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)

    abstract fun isTradeableConfig(): Boolean

    abstract fun isDiscoverableConfig(): Boolean

    abstract fun canApplyAtEnchantingTableConfig(): Boolean

    override fun isTradeable() = isTradeableConfig()

    override fun isDiscoverable() = isDiscoverableConfig()

    override fun isAllowedOnBooks() = canApplyAtEnchantingTableConfig()

    override fun canApplyAtEnchantingTable(stack: ItemStack) = canApplyAtEnchantingTableConfig() && super.canApplyAtEnchantingTable(stack)
}