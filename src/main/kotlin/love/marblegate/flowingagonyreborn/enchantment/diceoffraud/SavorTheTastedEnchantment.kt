package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object SavorTheTastedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.savorTheTasted,
    discoverableSetting = EnchantmentConfig.discoverableConfig.savorTheTasted, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.savorTheTasted,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.savorTheTasted, canEnchantSetting = EnchantmentConfig.canEnchantConfig.savorTheTasted, maxLevelValue = 3
)