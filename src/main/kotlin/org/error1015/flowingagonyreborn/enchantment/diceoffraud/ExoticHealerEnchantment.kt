package org.error1015.flowingagonyreborn.enchantment.diceoffraud

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ExoticHealerEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {

    override fun getConfig(): Boolean = Config.acquirableSettings.exoticHealer.get()
    override fun getMaxLevel() = 2
}