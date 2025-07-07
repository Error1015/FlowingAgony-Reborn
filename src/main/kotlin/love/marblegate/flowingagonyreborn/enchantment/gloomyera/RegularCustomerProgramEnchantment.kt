package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object RegularCustomerProgramEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.regularCustomerProgram

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.regularCustomerProgram

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.regularCustomerProgram

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.regularCustomerProgram

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true
}