package org.error1015.flowingagonyreborn.enchantment.madeofmadness

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object InsanePoetEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.insanePoet.get()
    override fun getMaxLevel() = 5
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != AgonyScreamerEnchantment && pOther != Enchantments.POWER_ARROWS && pOther != Enchantments.PUNCH_ARROWS
}