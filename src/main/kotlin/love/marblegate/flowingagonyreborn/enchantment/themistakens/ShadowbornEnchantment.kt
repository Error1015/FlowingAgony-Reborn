package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ShadowbornEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.shadowborn, isDiscoverable = EnchantmentConfig.discoverableConfig.shadowborn,
    canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.shadowborn, isTreasureOnly = EnchantmentConfig.isTreasureConfig.shadowborn,
    canEnchant = EnchantmentConfig.canEnchantConfig.shadowborn, maxLevel = 1
)