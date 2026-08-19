package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object NecessaryEvilEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.necessaryEvil,
    discoverableSetting = EnchantmentConfig.discoverableConfig.necessaryEvil,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.necessaryEvil,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.necessaryEvil,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.necessaryEvil,
    maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != SurvivalRuseEnchantment && pOther != SurvivalShortcutEnchantment
}