package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object BackAndFillEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = CustomEnchantmentCategory.bowAndCrossbow, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.backAndFill,
    discoverableSetting = EnchantmentConfig.discoverableConfig.backAndFill, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.backAndFill,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.backAndFill, canEnchantSetting = EnchantmentConfig.canEnchantConfig.backAndFill, maxLevelValue = 3
)