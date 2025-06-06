package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object EyesoreEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.eyesore.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.eyesore.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.eyesore.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.eyesore.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ThornInFleshEnchantment

    override fun isTreasureOnly() = true
}