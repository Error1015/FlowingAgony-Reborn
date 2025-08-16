package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object SavorTheTastedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.savorTheTasted,
    isDiscoverable = EnchantmentConfig.discoverableConfig.savorTheTasted, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.savorTheTasted,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.savorTheTasted, canEnchant = EnchantmentConfig.canEnchantConfig.savorTheTasted, maxLevel = 3
)