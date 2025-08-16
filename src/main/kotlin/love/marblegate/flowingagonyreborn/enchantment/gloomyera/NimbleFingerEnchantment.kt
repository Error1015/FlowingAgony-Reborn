package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = CustomEnchantmentCategory.swordArmorAndTool, pApplicableSlots = EquipmentSlotTypeSet.ALL, tradableSetting = EnchantmentConfig.tradableConfig.nimbleFinger,
    discoverableSetting = EnchantmentConfig.discoverableConfig.nimbleFinger, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.nimbleFinger,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.nimbleFinger, canEnchantSetting = EnchantmentConfig.canEnchantConfig.nimbleFinger, maxLevelValue = 3
)