package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object RegularCustomerProgramEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = CustomEnchantmentCategory.axeAndSwordItem,
    pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND,
    tradableSetting = EnchantmentConfig.tradableConfig.regularCustomerProgram,
    discoverableSetting = EnchantmentConfig.discoverableConfig.regularCustomerProgram,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.regularCustomerProgram,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.regularCustomerProgram,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.regularCustomerProgram,
    maxLevelValue = 1
)