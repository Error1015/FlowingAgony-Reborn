package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PotentialBurstEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_FEET,
    pApplicableSlots = EquipmentSlotTypeSet.FEET,
    tradableSetting = EnchantmentConfig.tradableConfig.potentialBurst,
    discoverableSetting = EnchantmentConfig.discoverableConfig.potentialBurst,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.potentialBurst,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.potentialBurst,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.potentialBurst,
    maxLevelValue = 3
)