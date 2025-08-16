package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object AnEnchantedGoldenAppleADayEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.anEnchantedGoldenAppleADay,
    isDiscoverable = EnchantmentConfig.discoverableConfig.anEnchantedGoldenAppleADay, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.anEnchantedGoldenAppleADay,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.anEnchantedGoldenAppleADay, canEnchant = EnchantmentConfig.canEnchantConfig.anEnchantedGoldenAppleADay, maxLevel = 1
)