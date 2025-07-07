package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ScholarOfOriginalSinEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.scholarOfOriginalSin

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.scholarOfOriginalSin

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.scholarOfOriginalSin

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.scholarOfOriginalSin

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != OriginalSinErosionEnchantment

    override fun isTreasureOnly() = true
}