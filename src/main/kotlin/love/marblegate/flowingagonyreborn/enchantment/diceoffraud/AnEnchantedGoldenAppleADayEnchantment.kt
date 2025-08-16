package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object AnEnchantedGoldenAppleADayEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, tradableSetting = EnchantmentConfig.tradableConfig.anEnchantedGoldenAppleADay,
    discoverableSetting = EnchantmentConfig.discoverableConfig.anEnchantedGoldenAppleADay, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.anEnchantedGoldenAppleADay,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.anEnchantedGoldenAppleADay, canEnchantSetting = EnchantmentConfig.canEnchantConfig.anEnchantedGoldenAppleADay, maxLevelValue = 1
)