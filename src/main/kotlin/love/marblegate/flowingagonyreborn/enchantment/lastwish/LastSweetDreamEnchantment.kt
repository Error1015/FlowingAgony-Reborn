package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LastSweetDreamEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BREAKABLE, pApplicableSlots = EquipmentSlotTypeSet.ALL, isTradable = EnchantmentConfig.tradableConfig.lastSweetDream,
    isDiscoverable = EnchantmentConfig.discoverableConfig.lastSweetDream, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.lastSweetDream,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.lastSweetDream, canEnchant = EnchantmentConfig.canEnchantConfig.lastSweetDream, maxLevel = 1
)