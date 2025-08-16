package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CorruptedKindredEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.corruptedKindred,
    isDiscoverable = EnchantmentConfig.discoverableConfig.corruptedKindred, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.corruptedKindred,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.corruptedKindred, canEnchant = EnchantmentConfig.canEnchantConfig.corruptedKindred, maxLevel = 5
)