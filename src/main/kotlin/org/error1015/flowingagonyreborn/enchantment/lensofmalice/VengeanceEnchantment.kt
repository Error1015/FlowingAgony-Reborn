package org.error1015.flowingagonyreborn.enchantment.lensofmalice

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object VengeanceEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.vengeance.get()
    override fun getMaxLevel() = 5
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != PerceivedMaliceEnchantment
}