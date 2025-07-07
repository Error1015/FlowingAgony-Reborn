package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CuttingWatermelonDreamEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.cuttingWatermelonDream

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.cuttingWatermelonDream

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.cuttingWatermelonDream

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.cuttingWatermelonDream

    override fun getMaxLevel() = 1

    override fun isTreasureOnly(): Boolean = true
}