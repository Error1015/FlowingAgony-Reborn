package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrayerOfPainEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.prayerOfPain,
    isDiscoverable = EnchantmentConfig.discoverableConfig.prayerOfPain, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.prayerOfPain,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.prayerOfPain, canEnchant = EnchantmentConfig.canEnchantConfig.prayerOfPain, maxLevel = 3,
    incompatibleEnchantments = listOf(BurningPhobiaEnchantment, DrowningPhobiaEnchantment)
)