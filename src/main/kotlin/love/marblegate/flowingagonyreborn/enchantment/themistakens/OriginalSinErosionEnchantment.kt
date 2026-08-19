package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object OriginalSinErosionEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.originalSinErosion,
    discoverableSetting = EnchantmentConfig.discoverableConfig.originalSinErosion,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.originalSinErosion,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.originalSinErosion,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.originalSinErosion,
    maxLevelValue = 3,
    incompatibleEnchantments = listOf(ScholarOfOriginalSinEnchantment)
)