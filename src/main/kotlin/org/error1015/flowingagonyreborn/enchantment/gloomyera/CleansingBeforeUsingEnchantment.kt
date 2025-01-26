package org.error1015.flowingagonyreborn.enchantment.gloomyera

import net.minecraft.world.item.ItemStack
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.evenyThing, EquipmentSlotTypeSet.ALL
) {
    private val config: Boolean = Config.acquirableSettings.cleansingBeforeUsing.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
    override fun isTradeable() = config
    override fun isDiscoverable() = config
    override fun isAllowedOnBooks() = config
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (config) super.canApplyAtEnchantingTable(stack) else false
}