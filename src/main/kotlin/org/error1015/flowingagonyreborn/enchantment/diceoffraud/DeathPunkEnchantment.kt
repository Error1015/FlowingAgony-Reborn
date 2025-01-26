package org.error1015.flowingagonyreborn.enchantment.diceoffraud

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object DeathPunkEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.deathPunk.get()
    override fun getMaxLevel() = 1
    override fun isTradeable() = getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false
}