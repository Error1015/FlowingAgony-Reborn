package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LightburnFungalParasiticEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.lightburnFungalParasitic,
    isDiscoverable = EnchantmentConfig.discoverableConfig.lightburnFungalParasitic, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.lightburnFungalParasitic,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.lightburnFungalParasitic, canEnchant = EnchantmentConfig.canEnchantConfig.lightburnFungalParasitic, maxLevel = 3
)