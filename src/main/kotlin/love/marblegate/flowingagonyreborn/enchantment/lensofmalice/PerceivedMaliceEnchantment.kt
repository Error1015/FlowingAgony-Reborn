package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PerceivedMaliceEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.perceivedMalice.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.perceivedMalice.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.perceivedMalice.get()

    override fun getMaxLevel() = 5

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != VengeanceEnchantment
}