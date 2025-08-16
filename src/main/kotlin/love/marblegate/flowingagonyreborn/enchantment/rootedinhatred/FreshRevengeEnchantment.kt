package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object FreshRevengeEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.freshRevenge,
    isDiscoverable = EnchantmentConfig.discoverableConfig.freshRevenge, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.freshRevenge,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.freshRevenge, canEnchant = EnchantmentConfig.canEnchantConfig.freshRevenge, maxLevel = 3
) {
    override fun getMaxLevel() = 3
}