package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import net.minecraft.world.item.enchantment.Enchantment
import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object EyesoreEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.eyesore.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ThornInFleshEnchantment
    override fun isTreasureOnly() = true
}