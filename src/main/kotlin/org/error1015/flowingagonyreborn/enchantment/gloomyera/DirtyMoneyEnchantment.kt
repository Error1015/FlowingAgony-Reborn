package org.error1015.flowingagonyreborn.enchantment.gloomyera

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object DirtyMoneyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.dirtyMoney.get()
    override fun getMaxLevel() = 2
    override fun isTreasureOnly() = true
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ComeBackAtDuskEnchantment
}