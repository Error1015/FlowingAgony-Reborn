package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object BackAndFillEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.bowAndCrossbow, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.backAndFill.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.backAndFill.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.backAndFill.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.backAndFill.get()

    override fun getMaxLevel() = 3
}