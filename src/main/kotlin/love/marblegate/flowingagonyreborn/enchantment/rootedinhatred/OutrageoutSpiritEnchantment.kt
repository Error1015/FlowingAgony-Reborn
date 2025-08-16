package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object OutrageoutSpiritEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = CustomEnchantmentCategory.axeAndSwordItem, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.outrageousSpirit,
    discoverableSetting = EnchantmentConfig.discoverableConfig.outrageousSpirit, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.outrageousSpirit,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.outrageousSpirit, canEnchantSetting = EnchantmentConfig.canEnchantConfig.outrageousSpirit, maxLevelValue = 5
)