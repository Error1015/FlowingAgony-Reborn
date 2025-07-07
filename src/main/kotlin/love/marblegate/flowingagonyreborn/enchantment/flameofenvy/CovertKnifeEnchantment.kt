package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CovertKnifeEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.covertKnife

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.covertKnife

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.covertKnife

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.covertKnife

    override fun getMaxLevel() = 3
}