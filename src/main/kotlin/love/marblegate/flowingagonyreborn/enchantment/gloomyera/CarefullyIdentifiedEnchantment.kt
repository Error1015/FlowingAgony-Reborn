package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = CustomEnchantmentCategory.pickaxe, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.carefullyIdentified,
    isDiscoverable = EnchantmentConfig.discoverableConfig.carefullyIdentified, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.carefullyIdentified,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.carefullyIdentified, canEnchant = EnchantmentConfig.canEnchantConfig.carefullyIdentified, maxLevel = 5
)