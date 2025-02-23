package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object InfectiousMaliceEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE,EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.infectiousMalice.get()
    override fun getMaxLevel() = 1
}