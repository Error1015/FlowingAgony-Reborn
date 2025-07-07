package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PerceivedMaliceEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.perceivedMalice

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.perceivedMalice

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.perceivedMalice

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.perceivedMalice

    override fun getMaxLevel() = 5

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != VengeanceEnchantment
}