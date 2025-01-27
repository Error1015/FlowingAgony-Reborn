package org.error1015.flowingagonyreborn.enchantment.innerpotential

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object StubbornStepEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.stubbornStep.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != FrivolousStepEnchantment
}