package org.error1015.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object CovertKnifeEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.covertKnife.get()
    override fun getMaxLevel() = 3
}