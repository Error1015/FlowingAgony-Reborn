package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PilferageCreedEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_FEET, pApplicableSlots = EquipmentSlotTypeSet.FEET, isTradable = EnchantmentConfig.tradableConfig.pilferageCreed,
    isDiscoverable = EnchantmentConfig.discoverableConfig.pilferageCreed, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.pilferageCreed,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.pilferageCreed, canEnchant = EnchantmentConfig.canEnchantConfig.pilferageCreed, maxLevel = 1
)