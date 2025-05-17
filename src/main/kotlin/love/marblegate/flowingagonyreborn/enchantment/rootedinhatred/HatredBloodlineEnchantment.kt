package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object HatredBloodlineEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.hatredBloodline.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.hatredBloodline.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.hatredBloodline.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.hatredBloodline.get()

    override fun getMaxLevel() = 3

    override fun isTradeable(): Boolean = true
}