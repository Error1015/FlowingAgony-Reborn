package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.everyThing, EquipmentSlotTypeSet.ALL
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.cleansingBeforeUsing.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.cleansingBeforeUsing.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.cleansingBeforeUsing.get()

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true
}