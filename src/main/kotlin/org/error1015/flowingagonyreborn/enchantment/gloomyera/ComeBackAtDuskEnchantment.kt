package org.error1015.flowingagonyreborn.enchantment.gloomyera

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ComeBackAtDuskEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.comeBackAtDusk.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != DirtyMoneyEnchantment
    override fun isTradeable() = getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false
}