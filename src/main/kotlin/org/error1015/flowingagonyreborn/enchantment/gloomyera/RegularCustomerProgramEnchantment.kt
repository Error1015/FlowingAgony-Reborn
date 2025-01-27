package org.error1015.flowingagonyreborn.enchantment.gloomyera

import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object RegularCustomerProgramEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.regularCustomerProgram.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
}