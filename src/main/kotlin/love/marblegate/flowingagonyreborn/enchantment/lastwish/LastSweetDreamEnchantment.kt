package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LastSweetDreamEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlotTypeSet.ALL
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.lastSweetDream

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.lastSweetDream

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.lastSweetDream

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.lastSweetDream

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true
}