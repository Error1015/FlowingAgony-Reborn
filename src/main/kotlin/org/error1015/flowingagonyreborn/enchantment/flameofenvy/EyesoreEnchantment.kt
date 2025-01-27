package org.error1015.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object EyesoreEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.eyesore.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ThornInFleshEnchantment
    override fun isTreasureOnly() = true
}