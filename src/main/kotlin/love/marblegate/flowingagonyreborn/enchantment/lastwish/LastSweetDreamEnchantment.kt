package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LastSweetDreamEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BREAKABLE, pApplicableSlots = EquipmentSlotTypeSet.ALL, tradableSetting = EnchantmentConfig.tradableConfig.lastSweetDream,
    discoverableSetting = EnchantmentConfig.discoverableConfig.lastSweetDream, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.lastSweetDream,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.lastSweetDream, canEnchantSetting = EnchantmentConfig.canEnchantConfig.lastSweetDream, maxLevelValue = 1
)