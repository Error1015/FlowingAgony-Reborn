package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SurvivalShortcutEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.survivalShortcut,
    isDiscoverable = EnchantmentConfig.discoverableConfig.survivalShortcut, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.survivalShortcut,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.survivalShortcut, canEnchant = EnchantmentConfig.canEnchantConfig.survivalShortcut, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != NecessaryEvilEnchantment && pOther != SurvivalRuseEnchantment
}