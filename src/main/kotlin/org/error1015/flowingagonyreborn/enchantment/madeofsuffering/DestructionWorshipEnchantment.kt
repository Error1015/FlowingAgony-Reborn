package org.error1015.flowingagonyreborn.enchantment.madeofsuffering

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object DestructionWorshipEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.destructionWorship.get()
    override fun getMaxLevel() = 1
    override fun checkCompatibility(pOther: Enchantment): Boolean =
        super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != PiercingFeverEnchantment
}