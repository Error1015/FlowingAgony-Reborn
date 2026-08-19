package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurningPhobiaEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_HEAD,
    pApplicableSlots = EquipmentSlotTypeSet.HEAD,
    tradableSetting = EnchantmentConfig.tradableConfig.burningPhobia,
    discoverableSetting = EnchantmentConfig.discoverableConfig.burningPhobia,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.burningPhobia,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.burningPhobia,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.burningPhobia,
    maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment): Boolean =
        super.checkCompatibility(pOther) && pOther != DrowningPhobiaEnchantment && pOther != PrayerOfPainEnchantment
}