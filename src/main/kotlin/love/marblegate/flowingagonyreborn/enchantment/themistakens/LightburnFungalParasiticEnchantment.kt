package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object LightburnFungalParasiticEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.lightburnFungalParasitic,
    discoverableSetting = EnchantmentConfig.discoverableConfig.lightburnFungalParasitic, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.lightburnFungalParasitic,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.lightburnFungalParasitic, canEnchantSetting = EnchantmentConfig.canEnchantConfig.lightburnFungalParasitic, maxLevelValue = 3
)