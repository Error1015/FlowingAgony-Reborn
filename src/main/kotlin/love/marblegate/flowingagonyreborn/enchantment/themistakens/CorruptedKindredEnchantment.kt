package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CorruptedKindredEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.corruptedKindred

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.corruptedKindred

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.corruptedKindred

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.corruptedKindred

    override fun getMaxLevel() = 5
}