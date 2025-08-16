package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.everyThing, pApplicableSlots = EquipmentSlotTypeSet.ALL, tradableSetting = EnchantmentConfig.tradableConfig.cleansingBeforeUsing,
    discoverableSetting = EnchantmentConfig.discoverableConfig.cleansingBeforeUsing, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.cleansingBeforeUsing,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.cleansingBeforeUsing, canEnchantSetting = EnchantmentConfig.canEnchantConfig.cleansingBeforeUsing, maxLevelValue = 1
)