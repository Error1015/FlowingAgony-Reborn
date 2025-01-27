package org.error1015.flowingagonyreborn.enchantment.innerpotential

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object PotentialBurstEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.potentialBurst.get()
    override fun getMaxLevel() = 3
}