package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ArmorUpEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.armorUp,
    isDiscoverable = EnchantmentConfig.discoverableConfig.armorUp, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.armorUp,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.armorUp, canEnchant = EnchantmentConfig.canEnchantConfig.armorUp, maxLevel = 3
)