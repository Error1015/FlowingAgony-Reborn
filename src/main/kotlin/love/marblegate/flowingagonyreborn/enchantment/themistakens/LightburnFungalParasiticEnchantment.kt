package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LightburnFungalParasiticEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.lightburnFungalParasitic,
    isDiscoverable = EnchantmentConfig.discoverableConfig.lightburnFungalParasitic, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.lightburnFungalParasitic,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.lightburnFungalParasitic, canEnchant = EnchantmentConfig.canEnchantConfig.lightburnFungalParasitic, maxLevel = 3
)