package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ExoticHealerEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.exoticHealer.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.exoticHealer.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.exoticHealer.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.exoticHealer.get()

    override fun getMaxLevel() = 2
}