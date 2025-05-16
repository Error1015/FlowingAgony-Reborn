package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object RegularCustomerProgramEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.regularCustomerProgram.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.regularCustomerProgram.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.regularCustomerProgram.get()

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true
}