package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object FrivolousStepEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.frivolousStep

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.frivolousStep

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.frivolousStep

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.frivolousStep

    override fun getMaxLevel() = 2

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != StubbornStepEnchantment
}