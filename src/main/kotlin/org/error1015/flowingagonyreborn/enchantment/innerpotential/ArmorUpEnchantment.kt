package org.error1015.flowingagonyreborn.enchantment.innerpotential

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ArmorUpEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    private val config: Boolean = Config.acquirableSettings.armorUp.get()
    override fun getMaxLevel() = 3
    override fun isTradeable() = config
    override fun isDiscoverable() = config
    override fun isAllowedOnBooks() = config
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (config) super.canApplyAtEnchantingTable(stack) else false
}