package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CuttingWatermelonDreamEnchantment: ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.cuttingWatermelonDream.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly(): Boolean = true
}