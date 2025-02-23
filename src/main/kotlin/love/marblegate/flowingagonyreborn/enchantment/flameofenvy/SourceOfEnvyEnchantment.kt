package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.enchantment.EnchantmentCategory
import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object SourceOfEnvyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.sourceOfEnvy.get()
    override fun getMaxLevel() = 5
}