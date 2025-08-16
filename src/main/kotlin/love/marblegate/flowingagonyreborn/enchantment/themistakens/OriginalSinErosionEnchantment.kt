package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object OriginalSinErosionEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.originalSinErosion,
    isDiscoverable = EnchantmentConfig.discoverableConfig.originalSinErosion, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.originalSinErosion,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.originalSinErosion, canEnchant = EnchantmentConfig.canEnchantConfig.originalSinErosion, maxLevel = 3,
    incompatibleEnchantments = listOf(ScholarOfOriginalSinEnchantment)
)