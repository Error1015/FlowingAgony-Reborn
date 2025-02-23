package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object FrivolousStepEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlotTypeSet.FEET
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.frivolousStep.get()
    override fun getMaxLevel() = 2
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != StubbornStepEnchantment
}