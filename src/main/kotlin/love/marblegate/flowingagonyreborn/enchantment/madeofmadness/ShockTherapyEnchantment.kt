package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object ShockTherapyEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.WEAPON, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.shockTherapy,
    discoverableSetting = EnchantmentConfig.discoverableConfig.shockTherapy, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.shockTherapy,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.shockTherapy, canEnchantSetting = EnchantmentConfig.canEnchantConfig.shockTherapy, maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != PaperBrainEnchantment && pOther != Enchantments.SHARPNESS && pOther != Enchantments.BANE_OF_ARTHROPODS && pOther != Enchantments.SMITE
}