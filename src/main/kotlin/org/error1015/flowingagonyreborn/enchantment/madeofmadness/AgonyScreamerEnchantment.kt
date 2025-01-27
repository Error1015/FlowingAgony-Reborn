package org.error1015.flowingagonyreborn.enchantment.madeofmadness

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object AgonyScreamerEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.agonyScreamer.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != InsanePoetEnchantment
}