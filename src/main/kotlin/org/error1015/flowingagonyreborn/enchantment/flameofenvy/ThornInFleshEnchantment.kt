package org.error1015.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ThornInFleshEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.thornInFlesh.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != EyesoreEnchantment
    override fun isTradeable() =getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false

}