package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SurvivalShortcutEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.survivalShortcut,
    discoverableSetting = EnchantmentConfig.discoverableConfig.survivalShortcut, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.survivalShortcut,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.survivalShortcut, canEnchantSetting = EnchantmentConfig.canEnchantConfig.survivalShortcut, maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != NecessaryEvilEnchantment && pOther != SurvivalRuseEnchantment
}