package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DrowningPhobiaEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, tradableSetting = EnchantmentConfig.tradableConfig.drowningPhobia,
    discoverableSetting = EnchantmentConfig.discoverableConfig.drowningPhobia, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.drowningPhobia,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.drowningPhobia, canEnchantSetting = EnchantmentConfig.canEnchantConfig.drowningPhobia, maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != BurningPhobiaEnchantment && pOther != PrayerOfPainEnchantment
}