package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object PaperBrainEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.paperBrain.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.paperBrain.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.paperBrain.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.paperBrain.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(other: Enchantment): Boolean =
        super.checkCompatibility(other) && other != ShockTherapyEnchantment && other != Enchantments.SHARPNESS && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE

}