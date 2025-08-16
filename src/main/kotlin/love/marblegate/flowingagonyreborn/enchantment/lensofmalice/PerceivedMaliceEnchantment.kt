package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PerceivedMaliceEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.perceivedMalice,
    isDiscoverable = EnchantmentConfig.discoverableConfig.perceivedMalice, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.perceivedMalice,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.perceivedMalice, canEnchant = EnchantmentConfig.canEnchantConfig.perceivedMalice, maxLevel = 5
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != VengeanceEnchantment
}