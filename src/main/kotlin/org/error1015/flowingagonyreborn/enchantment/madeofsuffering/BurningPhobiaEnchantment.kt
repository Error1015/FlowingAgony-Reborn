package org.error1015.flowingagonyreborn.enchantment.madeofsuffering

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object BurningPhobiaEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.burningPhobia.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != DrowningPhobiaEnchantment && pOther != PrayerOfPainEnchantment
}