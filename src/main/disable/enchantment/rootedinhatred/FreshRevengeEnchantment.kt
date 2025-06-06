package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object FreshRevengeEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.freshRevenge.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.freshRevenge.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.freshRevenge.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.freshRevenge.get()

    override fun getMaxLevel() = 3
}