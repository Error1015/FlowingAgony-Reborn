package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object CleansingBeforeUsingEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.everyThing, EquipmentSlotTypeSet.ALL
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.cleansingBeforeUsing.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
}