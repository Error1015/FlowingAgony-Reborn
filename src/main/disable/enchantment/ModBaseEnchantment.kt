package love.marblegate.flowingagonyreborn.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

abstract class ModBaseEnchantment(
    pRarity: Rarity,
    pCategory: EnchantmentCategory,
    pApplicableSlots: Array<EquipmentSlot>
) : Enchantment(pRarity, pCategory, pApplicableSlots), IModEnchantmentConfig {

    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)

    override fun isTradeable() = isTradableConfig()

    override fun isDiscoverable() = isDiscoverableConfig()

    override fun isAllowedOnBooks() = true

    override fun canApplyAtEnchantingTable(stack: ItemStack) = canApplyAtEnchantingTableConfig() && super.canApplyAtEnchantingTable(stack)

    override fun isTreasureOnly(): Boolean = isTreasureOnlyConfig()
}