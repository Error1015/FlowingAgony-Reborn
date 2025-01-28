package org.error1015.flowingagonyreborn.enchantment.gloomyera

import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.swordArmorAndTool, EquipmentSlotTypeSet.ALL
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.nimbleFinger.get()
    override fun getMaxLevel() = 3
}