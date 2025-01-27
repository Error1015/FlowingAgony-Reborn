package org.error1015.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object SourceOfEnvyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.sourceOfEnvy.get()
    override fun getMaxLevel() = 5
}