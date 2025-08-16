package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SurvivalRuseEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.survivalRuse,
    isDiscoverable = EnchantmentConfig.discoverableConfig.survivalRuse, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.survivalRuse,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.survivalRuse, canEnchant = EnchantmentConfig.canEnchantConfig.survivalRuse, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != NecessaryEvilEnchantment && pOther != SurvivalShortcutEnchantment
}