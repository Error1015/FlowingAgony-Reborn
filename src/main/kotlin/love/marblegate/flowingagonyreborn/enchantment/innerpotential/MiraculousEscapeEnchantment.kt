package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MiraculousEscapeEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, tradableSetting = EnchantmentConfig.tradableConfig.miraculousEscape,
    discoverableSetting = EnchantmentConfig.discoverableConfig.miraculousEscape, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.miraculousEscape,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.miraculousEscape, canEnchantSetting = EnchantmentConfig.canEnchantConfig.miraculousEscape, maxLevelValue = 1
)