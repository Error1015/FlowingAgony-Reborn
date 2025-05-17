package love.marblegate.flowingagonyreborn.enchantment.survivaltricks

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SurvivalRuseEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.survivalRuse.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.survivalRuse.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.survivalRuse.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.survivalRuse.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != NecessaryEvilEnchantment && pOther != SurvivalShortcutEnchantment
}