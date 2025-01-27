package org.error1015.flowingagonyreborn.enchantment.rootedinhatred

import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object OutrageoutSpiritEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, CustomEnchantmentCategory.axeAndSwordItem, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.outrageousSpirit.get()
    override fun getMaxLevel() = 5
}