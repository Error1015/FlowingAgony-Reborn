package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ArmorUpEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.armorUp

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.armorUp

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.armorUp

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.armorUp

    override fun getMaxLevel() = 3
}