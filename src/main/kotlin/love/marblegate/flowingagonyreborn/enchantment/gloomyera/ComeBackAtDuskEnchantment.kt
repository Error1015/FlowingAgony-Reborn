package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ComeBackAtDuskEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.comeBackAtDusk.get()
    override fun getMaxLevel() = 1
    override fun isTreasureOnly() = true
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != DirtyMoneyEnchantment
}