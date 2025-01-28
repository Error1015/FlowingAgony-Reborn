package org.error1015.flowingagonyreborn.enchantment.gloomyera

import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.everyThing, EquipmentSlotTypeSet.ALL
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.cleansingBeforeUsing.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
}