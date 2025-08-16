package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object FreshRevengeEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.freshRevenge,
    discoverableSetting = EnchantmentConfig.discoverableConfig.freshRevenge, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.freshRevenge,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.freshRevenge, canEnchantSetting = EnchantmentConfig.canEnchantConfig.freshRevenge, maxLevelValue = 3
) {
    fun getMaxLevelValue() = 3
}