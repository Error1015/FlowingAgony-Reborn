package org.error1015.flowingagonyreborn.enchantment.gloomyera

import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.pickaxe, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.carefullyIdentified.get()
    override fun getMaxLevel() = 5
}