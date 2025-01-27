package org.error1015.flowingagonyreborn.enchantment.lensofmalice

import net.minecraft.world.item.enchantment.EnchantmentCategory
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import org.error1015.flowingagonyreborn.enchantment.ModBaseEnchantment

object ISeeYouNowEnchantment: ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.iSeeYouNow.get()
    override fun getMaxLevel() = 1
}