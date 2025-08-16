package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object SourceOfEnvyEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.sourceOfEnvy,
    isDiscoverable = EnchantmentConfig.discoverableConfig.sourceOfEnvy, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.sourceOfEnvy,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.sourceOfEnvy, canEnchant = EnchantmentConfig.canEnchantConfig.sourceOfEnvy, maxLevel = 5
)