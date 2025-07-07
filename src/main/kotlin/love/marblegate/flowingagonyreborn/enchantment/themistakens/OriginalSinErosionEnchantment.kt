package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object OriginalSinErosionEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.originalSinErosion

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.originalSinErosion

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.originalSinErosion

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.originalSinErosion

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ScholarOfOriginalSinEnchantment

    override fun isTreasureOnly() = true
}