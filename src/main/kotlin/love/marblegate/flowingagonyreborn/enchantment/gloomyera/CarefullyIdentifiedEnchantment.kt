package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.pickaxe, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.carefullyIdentified.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.carefullyIdentified.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.carefullyIdentified.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.carefullyIdentified.get()

    override fun getMaxLevel() = 5
}