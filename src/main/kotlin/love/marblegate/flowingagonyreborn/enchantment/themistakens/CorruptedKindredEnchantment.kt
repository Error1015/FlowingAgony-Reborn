package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CorruptedKindredEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.corruptedKindred,
    discoverableSetting = EnchantmentConfig.discoverableConfig.corruptedKindred, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.corruptedKindred,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.corruptedKindred, canEnchantSetting = EnchantmentConfig.canEnchantConfig.corruptedKindred, maxLevelValue = 5
)