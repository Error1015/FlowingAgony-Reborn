package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object TricksterEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.trickster,
    isDiscoverable = EnchantmentConfig.discoverableConfig.trickster, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.trickster,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.trickster, canEnchant = EnchantmentConfig.canEnchantConfig.trickster, maxLevel = 2
)