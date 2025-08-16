package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.prototypeChaotic,
    isDiscoverable = EnchantmentConfig.discoverableConfig.prototypeChaotic, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaotic,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.prototypeChaotic, canEnchant = EnchantmentConfig.canEnchantConfig.prototypeChaotic, maxLevel = 3
)