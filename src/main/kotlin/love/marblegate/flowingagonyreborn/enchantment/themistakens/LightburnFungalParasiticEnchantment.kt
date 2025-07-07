package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LightburnFungalParasiticEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.lightburnFungalParasitic

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.lightburnFungalParasitic

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.lightburnFungalParasitic

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.lightburnFungalParasitic

    override fun getMaxLevel() = 3

    override fun isTreasureOnly() = true
}