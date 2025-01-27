package org.error1015.flowingagonyreborn.enchantment.lensofmalice

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object MaliceOutbreakEnchantment: ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.maliceOutbreak.get()
    override fun getMaxLevel() = 5
}