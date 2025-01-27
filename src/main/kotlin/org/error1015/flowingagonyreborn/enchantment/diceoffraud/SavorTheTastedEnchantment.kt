package org.error1015.flowingagonyreborn.enchantment.diceoffraud

import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object SavorTheTastedEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.savorTheTasted.get()
    override fun getMaxLevel() = 3
}