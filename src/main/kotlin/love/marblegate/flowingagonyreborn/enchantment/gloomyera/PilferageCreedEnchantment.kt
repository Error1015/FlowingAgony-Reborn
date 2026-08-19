package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PilferageCreedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_FEET,
    pApplicableSlots = EquipmentSlotTypeSet.FEET,
    tradableSetting = EnchantmentConfig.tradableConfig.pilferageCreed,
    discoverableSetting = EnchantmentConfig.discoverableConfig.pilferageCreed,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.pilferageCreed,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.pilferageCreed,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.pilferageCreed,
    maxLevelValue = 1
)