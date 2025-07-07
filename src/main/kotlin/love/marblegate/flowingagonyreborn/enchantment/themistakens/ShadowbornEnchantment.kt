package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ShadowbornEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.shadowborn

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.shadowborn

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.shadowborn

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.shadowborn

    override fun getMaxLevel() = 1
}