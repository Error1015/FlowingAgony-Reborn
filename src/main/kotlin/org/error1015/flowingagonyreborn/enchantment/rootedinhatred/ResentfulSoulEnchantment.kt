package org.error1015.flowingagonyreborn.enchantment.rootedinhatred

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ResentfulSoulEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.resentfulSoul.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != TooResentfulToDieEnchantment
    override fun isTreasureOnly() = true

}