package org.error1015.flowingagonyreborn.enchantment.gloomyera

import net.minecraft.world.item.ItemStack
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CarefullyIdentifiedEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, CustomEnchantmentCategory.pickaxe, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.carefullyIdentified.get()
    override fun getMaxLevel() = 5
    override fun isTradeable() = getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false
}