package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CuttingWatermelonDreamEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.DIGGER,
    pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND,
    tradableSetting = EnchantmentConfig.tradableConfig.cuttingWatermelonDream,
    discoverableSetting = EnchantmentConfig.discoverableConfig.cuttingWatermelonDream,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.cuttingWatermelonDream,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.cuttingWatermelonDream,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.cuttingWatermelonDream,
    maxLevelValue = 1
)