package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PotentialBurstEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, isTradable = EnchantmentConfig.tradableConfig.potentialBurst,
    isDiscoverable = EnchantmentConfig.discoverableConfig.potentialBurst, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.potentialBurst,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.potentialBurst, canEnchant = EnchantmentConfig.canEnchantConfig.potentialBurst, maxLevel = 3
)