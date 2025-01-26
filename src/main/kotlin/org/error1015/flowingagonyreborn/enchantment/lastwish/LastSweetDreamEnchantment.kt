package org.error1015.flowingagonyreborn.enchantment.lastwish

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object LastSweetDreamEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlotTypeSet.ALL
) {
    private val config: Boolean = Config.acquirableSettings.lastSweetDream.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
    override fun isTradeable() = config
    override fun isDiscoverable() = config
    override fun isAllowedOnBooks() = config
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (config) super.canApplyAtEnchantingTable(stack) else false
}