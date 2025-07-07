package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.swordArmorAndTool, EquipmentSlotTypeSet.ALL
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.nimbleFinger

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.nimbleFinger

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.nimbleFinger

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.nimbleFinger

    override fun getMaxLevel() = 3
}