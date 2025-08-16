package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DrowningPhobiaEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.drowningPhobia,
    isDiscoverable = EnchantmentConfig.discoverableConfig.drowningPhobia, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.drowningPhobia,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.drowningPhobia, canEnchant = EnchantmentConfig.canEnchantConfig.drowningPhobia, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != BurningPhobiaEnchantment && pOther != PrayerOfPainEnchantment
}