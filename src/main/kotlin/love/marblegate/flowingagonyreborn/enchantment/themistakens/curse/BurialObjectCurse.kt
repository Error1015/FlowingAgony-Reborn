package love.marblegate.flowingagonyreborn.enchantment.themistakens.curse

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurialObjectCurse : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.burialObject.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.burialObject.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.burialObject.get()

    override fun getMaxLevel() = 1

    override fun isCurse() = true

    override fun canApplyAtEnchantingTable(stack: ItemStack) = false
}