package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ScholarOfOriginalSinEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.scholarOfOriginalSin,
    isDiscoverable = EnchantmentConfig.discoverableConfig.scholarOfOriginalSin, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.scholarOfOriginalSin,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.scholarOfOriginalSin, canEnchant = EnchantmentConfig.canEnchantConfig.scholarOfOriginalSin, maxLevel = 3,
    incompatibleEnchantments = listOf(OriginalSinErosionEnchantment)
)