package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object RegularCustomerProgramEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND,
    isTradable = EnchantmentConfig.tradableConfig.regularCustomerProgram, isDiscoverable = EnchantmentConfig.discoverableConfig.regularCustomerProgram,
    canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.regularCustomerProgram, isTreasureOnly = EnchantmentConfig.isTreasureConfig.regularCustomerProgram,
    canEnchant = EnchantmentConfig.canEnchantConfig.regularCustomerProgram, maxLevel = 1
)