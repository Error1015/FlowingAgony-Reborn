package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.swordArmorAndTool, pApplicableSlots = EquipmentSlotTypeSet.ALL, isTradable = EnchantmentConfig.tradableConfig.nimbleFinger,
    isDiscoverable = EnchantmentConfig.discoverableConfig.nimbleFinger, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.nimbleFinger,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.nimbleFinger, canEnchant = EnchantmentConfig.canEnchantConfig.nimbleFinger, maxLevel = 3
)