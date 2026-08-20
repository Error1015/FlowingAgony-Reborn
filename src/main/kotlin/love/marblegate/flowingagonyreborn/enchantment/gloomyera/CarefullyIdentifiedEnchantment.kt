package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.pickaxe, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.carefullyIdentified

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.carefullyIdentified

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.carefullyIdentified

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.carefullyIdentified

    override fun getMaxLevel() = 5
}