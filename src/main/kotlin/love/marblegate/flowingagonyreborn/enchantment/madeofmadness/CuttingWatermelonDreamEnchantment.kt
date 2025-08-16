package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CuttingWatermelonDreamEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.DIGGER, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.cuttingWatermelonDream,
    isDiscoverable = EnchantmentConfig.discoverableConfig.cuttingWatermelonDream, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.cuttingWatermelonDream,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.cuttingWatermelonDream, canEnchant = EnchantmentConfig.canEnchantConfig.cuttingWatermelonDream, maxLevel = 1
)