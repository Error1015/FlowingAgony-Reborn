package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MiraculousEscapeEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, isTradable = EnchantmentConfig.tradableConfig.miraculousEscape,
    isDiscoverable = EnchantmentConfig.discoverableConfig.miraculousEscape, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.miraculousEscape,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.miraculousEscape, canEnchant = EnchantmentConfig.canEnchantConfig.miraculousEscape, maxLevel = 1
)