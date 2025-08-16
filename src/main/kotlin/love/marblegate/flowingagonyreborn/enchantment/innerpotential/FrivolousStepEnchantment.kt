package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object FrivolousStepEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, tradableSetting = EnchantmentConfig.tradableConfig.frivolousStep,
    discoverableSetting = EnchantmentConfig.discoverableConfig.frivolousStep, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.frivolousStep,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.frivolousStep, canEnchantSetting = EnchantmentConfig.canEnchantConfig.frivolousStep, maxLevelValue = 2
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != StubbornStepEnchantment
}