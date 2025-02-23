package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DirtyMoneyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.dirtyMoney.get()
    override fun getMaxLevel() = 2
    override fun isTreasureOnly() = true
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ComeBackAtDuskEnchantment
}