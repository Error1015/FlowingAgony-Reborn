package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DrowningPhobiaEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.drowningPhobia,
    isDiscoverable = EnchantmentConfig.discoverableConfig.drowningPhobia, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.drowningPhobia,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.drowningPhobia, canEnchant = EnchantmentConfig.canEnchantConfig.drowningPhobia, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != BurningPhobiaEnchantment && pOther != PrayerOfPainEnchantment
}