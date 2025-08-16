package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object OutrageoutSpiritEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.outrageousSpirit,
    isDiscoverable = EnchantmentConfig.discoverableConfig.outrageousSpirit, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.outrageousSpirit,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.outrageousSpirit, canEnchant = EnchantmentConfig.canEnchantConfig.outrageousSpirit, maxLevel = 5
)