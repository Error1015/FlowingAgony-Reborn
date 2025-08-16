package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.prototypeChaotic,
    isDiscoverable = EnchantmentConfig.discoverableConfig.prototypeChaotic, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaotic,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.prototypeChaotic, canEnchant = EnchantmentConfig.canEnchantConfig.prototypeChaotic, maxLevel = 3
)