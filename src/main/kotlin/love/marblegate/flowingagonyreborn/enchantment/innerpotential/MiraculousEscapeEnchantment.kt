package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MiraculousEscapeEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.miraculousEscape

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.miraculousEscape

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.miraculousEscape

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.miraculousEscape

    override fun getMaxLevel() = 1
}