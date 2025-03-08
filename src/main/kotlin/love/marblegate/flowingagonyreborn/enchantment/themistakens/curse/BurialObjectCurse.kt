package love.marblegate.flowingagonyreborn.enchantment.themistakens.curse

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurialObjectCurse : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.burialObject.get()
    override fun getMaxLevel() = 1
    override fun isCurse() = true
    override fun canApplyAtEnchantingTable(stack: ItemStack) = false
}