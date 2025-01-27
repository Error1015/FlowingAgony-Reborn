package org.error1015.flowingagonyreborn.enchantment.madeofmadness

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment


object PaperBrainEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.paperBrain.get()
    override fun getMaxLevel() = 3

    override fun checkCompatibility(other: Enchantment): Boolean =
        super.checkCompatibility(other) && other != ShockTherapyEnchantment && other != Enchantments.SHARPNESS && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE

}