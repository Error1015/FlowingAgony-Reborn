package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object OutrageoutSpiritEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.outrageousSpirit.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.outrageousSpirit.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.outrageousSpirit.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.outrageousSpirit.get()

    override fun getMaxLevel() = 5
}