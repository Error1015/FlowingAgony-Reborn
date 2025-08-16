package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ISeeYouNowEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.iSeeYouNow,
    isDiscoverable = EnchantmentConfig.discoverableConfig.iSeeYouNow, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.iSeeYouNow,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.iSeeYouNow, canEnchant = EnchantmentConfig.canEnchantConfig.iSeeYouNow, maxLevel = 1
)