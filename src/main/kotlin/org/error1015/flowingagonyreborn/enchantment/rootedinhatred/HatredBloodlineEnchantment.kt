package org.error1015.flowingagonyreborn.enchantment.rootedinhatred

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object HatredBloodlineEnchantment: ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.hatredBloodline.get()
    override fun getMaxLevel() = 3
    override fun isTradeable(): Boolean = true
}