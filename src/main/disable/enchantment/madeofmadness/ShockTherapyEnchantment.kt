package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object ShockTherapyEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.shockTherapy.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.shockTherapy.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.shockTherapy.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.shockTherapy.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != PaperBrainEnchantment && pOther != Enchantments.SHARPNESS && pOther != Enchantments.BANE_OF_ARTHROPODS && pOther != Enchantments.SMITE
}