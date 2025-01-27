package org.error1015.flowingagonyreborn.enchantment.madeofmadness

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CuttingWatermelonDreamEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.cuttingWatermelonDream.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly(): Boolean = true
}