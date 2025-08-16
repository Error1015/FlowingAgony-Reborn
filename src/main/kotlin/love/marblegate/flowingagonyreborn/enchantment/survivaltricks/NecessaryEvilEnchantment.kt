package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object NecessaryEvilEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.necessaryEvil,
    isDiscoverable = EnchantmentConfig.discoverableConfig.necessaryEvil, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.necessaryEvil,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.necessaryEvil, canEnchant = EnchantmentConfig.canEnchantConfig.necessaryEvil, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != SurvivalRuseEnchantment && pOther != SurvivalShortcutEnchantment
}