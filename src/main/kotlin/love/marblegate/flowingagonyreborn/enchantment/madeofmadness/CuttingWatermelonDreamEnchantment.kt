package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CuttingWatermelonDreamEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.cuttingWatermelonDream.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.cuttingWatermelonDream.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.cuttingWatermelonDream.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.cuttingWatermelonDream.get()

    override fun getMaxLevel() = 1

    override fun isTreasureOnly(): Boolean = true
}