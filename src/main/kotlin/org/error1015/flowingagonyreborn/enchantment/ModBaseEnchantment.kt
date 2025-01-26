package org.error1015.flowingagonyreborn.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

open class ModBaseEnchantment(pRarity: Rarity, pCategory: EnchantmentCategory, pApplicableSlots: Array<out EquipmentSlot>) : Enchantment(pRarity, pCategory, pApplicableSlots) {
    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)
}