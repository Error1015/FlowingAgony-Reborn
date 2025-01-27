package org.error1015.flowingagonyreborn.enchantment.themistakens.curse

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object BurialObjectCurse : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.burialObject.get()
    override fun getMaxLevel() = 1
    override fun isCurse() = true
    override fun canApplyAtEnchantingTable(stack: ItemStack) = false
}