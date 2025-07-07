package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ResentfulSoulEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.resentfulSoul

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.resentfulSoul

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.resentfulSoul

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.resentfulSoul

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != TooResentfulToDieEnchantment

    override fun isTreasureOnly() = true
}