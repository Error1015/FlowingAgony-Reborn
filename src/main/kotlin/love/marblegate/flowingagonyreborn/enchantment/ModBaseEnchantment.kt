package love.marblegate.flowingagonyreborn.enchantment

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

abstract class ModBaseEnchantment(pRarity: Rarity, pCategory: EnchantmentCategory, pApplicableSlots: Array<out EquipmentSlot>) : Enchantment(pRarity, pCategory, pApplicableSlots) {
    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)

    abstract fun getConfig(): Boolean

    override fun isTradeable() = getConfig()
    override fun isDiscoverable() = getConfig()
    override fun isAllowedOnBooks() = getConfig()
    override fun canApplyAtEnchantingTable(stack: ItemStack) = if (getConfig()) super.canApplyAtEnchantingTable(stack) else false
}