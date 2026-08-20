package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object InfectiousMaliceEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.infectiousMalice

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.infectiousMalice

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.infectiousMalice

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.infectiousMalice

    override fun getMaxLevel() = 1
}