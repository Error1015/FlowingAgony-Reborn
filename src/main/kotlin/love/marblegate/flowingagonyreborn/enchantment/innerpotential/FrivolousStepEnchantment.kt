package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object FrivolousStepEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, isTradable = EnchantmentConfig.tradableConfig.frivolousStep,
    isDiscoverable = EnchantmentConfig.discoverableConfig.frivolousStep, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.frivolousStep,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.frivolousStep, canEnchant = EnchantmentConfig.canEnchantConfig.frivolousStep, maxLevel = 2
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != StubbornStepEnchantment
}