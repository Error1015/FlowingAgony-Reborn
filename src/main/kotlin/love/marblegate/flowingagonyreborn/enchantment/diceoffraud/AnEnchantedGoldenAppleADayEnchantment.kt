package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object AnEnchantedGoldenAppleADayEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.anEnchantedGoldenAppleADay.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.anEnchantedGoldenAppleADay.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.anEnchantedGoldenAppleADay.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.anEnchantedGoldenAppleADay.get()

    override fun getMaxLevel() = 1
}