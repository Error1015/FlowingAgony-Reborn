package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PilferageCreedEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.pilferageCreed

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.pilferageCreed

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.pilferageCreed

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.pilferageCreed

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true
}