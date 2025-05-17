package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object TooResentfulToDieEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.tooResentfulToDie.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.tooResentfulToDie.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.tooResentfulToDie.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.tooResentfulToDie.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ResentfulSoulEnchantment

    override fun isTreasureOnly() = true
}