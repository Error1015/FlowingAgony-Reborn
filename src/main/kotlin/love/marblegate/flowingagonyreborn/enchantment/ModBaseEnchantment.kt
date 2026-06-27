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
    open val tradableSetting: Boolean,
    open val discoverableSetting: Boolean,
    open val canEnchantSetting: Boolean = true,
    open val canApplyOnEnchantingTableSetting: Boolean,
    open val isTreasureOnlySettings: Boolean,
    open val maxLevelValue: Int = 1,
    open val incompatibleEnchantments: List<Enchantment> = emptyList() // 冲突附魔列表
) : Enchantment(pRarity, pCategory, pApplicableSlots) {
    override fun getMinCost(pLevel: Int) = getEnchantability(pLevel, true)

    override fun getMaxCost(pLevel: Int) = getEnchantability(pLevel, false)

    override fun isTradeable() = tradableSetting

    override fun isDiscoverable() = discoverableSetting

    override fun isAllowedOnBooks() = true

    override fun canEnchant(pStack: ItemStack): Boolean = canEnchantSetting

    override fun canApplyAtEnchantingTable(stack: ItemStack) = canApplyOnEnchantingTableSetting && super.canApplyAtEnchantingTable(stack)

    override fun isTreasureOnly(): Boolean = isTreasureOnlySettings

    override fun getMaxLevel() = maxLevelValue

    /**
     * 当另一个附魔不存在冲突列表中则通过
     */
    override fun checkCompatibility(pOther: Enchantment): Boolean = pOther !in incompatibleEnchantments && super.checkCompatibility(pOther)

}