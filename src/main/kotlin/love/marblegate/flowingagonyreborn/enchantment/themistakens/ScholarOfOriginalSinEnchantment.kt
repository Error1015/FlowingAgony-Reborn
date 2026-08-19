package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ScholarOfOriginalSinEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.scholarOfOriginalSin,
    discoverableSetting = EnchantmentConfig.discoverableConfig.scholarOfOriginalSin,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.scholarOfOriginalSin,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.scholarOfOriginalSin,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.scholarOfOriginalSin,
    maxLevelValue = 3,
    incompatibleEnchantments = listOf(OriginalSinErosionEnchantment)
)