package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object EnviousKindEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.enviousKind,
    isDiscoverable = EnchantmentConfig.discoverableConfig.enviousKind, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.enviousKind,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.enviousKind, canEnchant = EnchantmentConfig.canEnchantConfig.enviousKind, maxLevel = 1
)