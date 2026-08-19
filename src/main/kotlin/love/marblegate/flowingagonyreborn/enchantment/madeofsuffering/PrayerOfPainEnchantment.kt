package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrayerOfPainEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_HEAD,
    pApplicableSlots = EquipmentSlotTypeSet.HEAD,
    tradableSetting = EnchantmentConfig.tradableConfig.prayerOfPain,
    discoverableSetting = EnchantmentConfig.discoverableConfig.prayerOfPain,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.prayerOfPain,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.prayerOfPain,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.prayerOfPain,
    maxLevelValue = 3,
    incompatibleEnchantments = listOf(BurningPhobiaEnchantment, DrowningPhobiaEnchantment)
)