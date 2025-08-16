package love.marblegate.flowingagonyreborn.enchantment

import love.marblegate.flowingagonyreborn.util.getEnchantability
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

abstract class ModBaseEnchantment(
    pRarity: Rarity,
    pCategory: EnchantmentCategory,
    pApplicableSlots: Array<EquipmentSlot>,
    open val isTradable: Boolean,
    open val isDiscoverable: Boolean,
    open val canEnchant: Boolean = true,
    open val canApplyOnEnchantingTable: Boolean,
    open val isTreasureOnly: Boolean,
    open val maxLevel: Int = 1,
    open val incompatibleEnchantments: List<Enchantment> = emptyList() // 冲突附魔列表
) : Enchantment(pRarity, pCategory, pApplicableSlots) {
    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)

    override fun isTradeable() = isTradable

    override fun isDiscoverable() = isDiscoverable

    override fun isAllowedOnBooks() = true

    override fun canEnchant(pStack: ItemStack): Boolean = canEnchant

    override fun canApplyAtEnchantingTable(stack: ItemStack) = canApplyOnEnchantingTable && super.canApplyAtEnchantingTable(stack)

    override fun isTreasureOnly(): Boolean = isTreasureOnly

    override fun getMaxLevel() = maxLevel

    /**
     * 当另一个附魔不存在冲突列表中则通过
     */
    override fun checkCompatibility(pOther: Enchantment): Boolean = pOther !in incompatibleEnchantments && super.checkCompatibility(pOther)

}