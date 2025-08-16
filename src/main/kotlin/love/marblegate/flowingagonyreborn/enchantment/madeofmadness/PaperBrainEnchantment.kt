package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object PaperBrainEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.WEAPON, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.paperBrain,
    discoverableSetting = EnchantmentConfig.discoverableConfig.paperBrain, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.paperBrain,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.paperBrain, canEnchantSetting = EnchantmentConfig.canEnchantConfig.paperBrain, maxLevelValue = 3
) {
    override fun checkCompatibility(other: Enchantment): Boolean =
        super.checkCompatibility(other) && other != ShockTherapyEnchantment && other != Enchantments.SHARPNESS && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE

}