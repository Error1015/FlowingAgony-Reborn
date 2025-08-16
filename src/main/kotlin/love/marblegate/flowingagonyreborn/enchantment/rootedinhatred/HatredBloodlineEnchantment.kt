package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object HatredBloodlineEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.hatredBloodline,
    isDiscoverable = EnchantmentConfig.discoverableConfig.hatredBloodline, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.hatredBloodline,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.hatredBloodline, canEnchant = EnchantmentConfig.canEnchantConfig.hatredBloodline, maxLevel = 3
)