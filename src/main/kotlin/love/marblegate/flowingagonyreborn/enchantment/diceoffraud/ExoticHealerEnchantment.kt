package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ExoticHealerEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.exoticHealer

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.exoticHealer

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.exoticHealer

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.exoticHealer

    override fun getMaxLevel() = 2
}