package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SourceOfEnvyEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.sourceOfEnvy,
    discoverableSetting = EnchantmentConfig.discoverableConfig.sourceOfEnvy, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.sourceOfEnvy,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.sourceOfEnvy, canEnchantSetting = EnchantmentConfig.canEnchantConfig.sourceOfEnvy, maxLevelValue = 5
)