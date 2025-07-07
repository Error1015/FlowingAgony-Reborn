package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SourceOfEnvyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.sourceOfEnvy

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.sourceOfEnvy

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.sourceOfEnvy

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.sourceOfEnvy

    override fun getMaxLevel() = 5
}