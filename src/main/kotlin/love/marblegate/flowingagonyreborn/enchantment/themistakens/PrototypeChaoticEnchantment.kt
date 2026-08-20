package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.prototypeChaotic

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.prototypeChaotic

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaotic

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.prototypeChaotic

    override fun getMaxLevel() = 3
}