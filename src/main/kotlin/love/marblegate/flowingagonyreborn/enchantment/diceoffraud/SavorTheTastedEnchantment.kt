package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object SavorTheTastedEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.savorTheTasted

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.savorTheTasted

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.savorTheTasted

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.savorTheTasted

    override fun getMaxLevel() = 3
}