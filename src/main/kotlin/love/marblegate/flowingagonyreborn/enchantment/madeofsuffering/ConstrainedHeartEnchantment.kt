package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ConstrainedHeartEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.constrainedHeart.get()
    override fun getMaxLevel() = 1
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != PiercingFeverEnchantment && pOther != DestructionWorshipEnchantment

}