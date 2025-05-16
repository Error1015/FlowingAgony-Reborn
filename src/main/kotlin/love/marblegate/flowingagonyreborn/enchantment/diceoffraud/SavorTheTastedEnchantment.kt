package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object SavorTheTastedEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.savorTheTasted.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.savorTheTasted.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.savorTheTasted.get()

    override fun getMaxLevel() = 3
}