package org.error1015.flowingagonyreborn.enchantment.gloomyera

import net.minecraft.world.item.ItemStack
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.swordArmorAndTool, EquipmentSlotTypeSet.ALL
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.nimbleFinger.get()
    override fun getMaxLevel() = 3
    override fun isTradeable() = getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false
}