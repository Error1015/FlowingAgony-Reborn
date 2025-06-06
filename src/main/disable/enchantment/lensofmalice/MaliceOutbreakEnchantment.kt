package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MaliceOutbreakEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.maliceOutbreak.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.maliceOutbreak.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.maliceOutbreak.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.maliceOutbreak.get()

    override fun getMaxLevel() = 5
}