package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PotentialBurstEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.potentialBurst.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.potentialBurst.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.potentialBurst.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.potentialBurst.get()

    override fun getMaxLevel() = 3
}