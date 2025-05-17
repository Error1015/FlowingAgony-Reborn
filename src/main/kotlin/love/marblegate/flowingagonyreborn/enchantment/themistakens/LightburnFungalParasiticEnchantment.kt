package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LightburnFungalParasiticEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.lightburnFungalParasitic.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.lightburnFungalParasitic.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.lightburnFungalParasitic.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.lightburnFungalParasitic.get()

    override fun getMaxLevel() = 3

    override fun isTreasureOnly() = true
}