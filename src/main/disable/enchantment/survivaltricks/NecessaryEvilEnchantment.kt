package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object NecessaryEvilEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.necessaryEvil.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.necessaryEvil.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.necessaryEvil.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.necessaryEvil.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != SurvivalRuseEnchantment && pOther != SurvivalShortcutEnchantment
}