package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrayerOfPainEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.prayerOfPain,
    isDiscoverable = EnchantmentConfig.discoverableConfig.prayerOfPain, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.prayerOfPain,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.prayerOfPain, canEnchant = EnchantmentConfig.canEnchantConfig.prayerOfPain, maxLevel = 3,
    incompatibleEnchantments = listOf(BurningPhobiaEnchantment, DrowningPhobiaEnchantment)
)