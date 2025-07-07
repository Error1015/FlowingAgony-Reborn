package love.marblegate.flowingagonyreborn.enchantment.themistakens.curse

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurialObjectCurse : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.burialObject

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.burialObject

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.burialObject

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.burialObject

    override fun getMaxLevel() = 1

    override fun isCurse() = true

    override fun canApplyAtEnchantingTable(stack: ItemStack) = false
}