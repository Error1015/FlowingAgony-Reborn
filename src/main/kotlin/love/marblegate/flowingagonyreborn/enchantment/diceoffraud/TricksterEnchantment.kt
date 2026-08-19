package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object TricksterEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = CustomEnchantmentCategory.axeAndSwordItem,
    pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND,
    tradableSetting = EnchantmentConfig.tradableConfig.trickster,
    discoverableSetting = EnchantmentConfig.discoverableConfig.trickster,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.trickster,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.trickster,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.trickster,
    maxLevelValue = 2
)