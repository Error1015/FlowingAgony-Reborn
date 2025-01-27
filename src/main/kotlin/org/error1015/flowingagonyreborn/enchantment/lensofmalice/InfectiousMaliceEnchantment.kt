package org.error1015.flowingagonyreborn.enchantment.lensofmalice

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object InfectiousMaliceEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE,EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.infectiousMalice.get()
    override fun getMaxLevel() = 1
}