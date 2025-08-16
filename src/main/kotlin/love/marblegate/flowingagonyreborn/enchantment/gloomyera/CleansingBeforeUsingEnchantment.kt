package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.everyThing, pApplicableSlots = EquipmentSlotTypeSet.ALL, isTradable = EnchantmentConfig.tradableConfig.cleansingBeforeUsing,
    isDiscoverable = EnchantmentConfig.discoverableConfig.cleansingBeforeUsing, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.cleansingBeforeUsing,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.cleansingBeforeUsing, canEnchant = EnchantmentConfig.canEnchantConfig.cleansingBeforeUsing, maxLevel = 1
)