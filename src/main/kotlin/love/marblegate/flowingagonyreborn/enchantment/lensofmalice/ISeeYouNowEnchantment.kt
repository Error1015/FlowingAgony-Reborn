package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ISeeYouNowEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, tradableSetting = EnchantmentConfig.tradableConfig.iSeeYouNow,
    discoverableSetting = EnchantmentConfig.discoverableConfig.iSeeYouNow, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.iSeeYouNow,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.iSeeYouNow, canEnchantSetting = EnchantmentConfig.canEnchantConfig.iSeeYouNow, maxLevelValue = 1
)