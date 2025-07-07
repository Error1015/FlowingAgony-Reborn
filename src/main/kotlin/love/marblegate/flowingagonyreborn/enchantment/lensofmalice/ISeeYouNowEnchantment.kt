package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ISeeYouNowEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.iSeeYouNow

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.iSeeYouNow

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.iSeeYouNow

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.iSeeYouNow

    override fun getMaxLevel() = 1
}