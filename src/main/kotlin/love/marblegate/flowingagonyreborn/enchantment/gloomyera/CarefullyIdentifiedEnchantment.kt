package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = CustomEnchantmentCategory.pickaxe, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.carefullyIdentified,
    discoverableSetting = EnchantmentConfig.discoverableConfig.carefullyIdentified, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.carefullyIdentified,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.carefullyIdentified, canEnchantSetting = EnchantmentConfig.canEnchantConfig.carefullyIdentified, maxLevelValue = 5
)