package org.error1015.flowingagonyreborn.enchantment.innerpotential

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object FrivolousStepEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.frivolousStep.get()
    override fun getMaxLevel() = 2
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != StubbornStepEnchantment
}