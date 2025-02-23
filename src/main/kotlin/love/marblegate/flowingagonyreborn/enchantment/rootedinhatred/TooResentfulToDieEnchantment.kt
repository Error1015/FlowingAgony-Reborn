package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object TooResentfulToDieEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.tooResentfulToDie.get()
    override fun getMaxLevel() = 3
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ResentfulSoulEnchantment
    override fun isTreasureOnly() = true
}