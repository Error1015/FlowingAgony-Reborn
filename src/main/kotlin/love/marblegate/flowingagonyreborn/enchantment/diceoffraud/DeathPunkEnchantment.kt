package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DeathPunkEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.deathPunk,
    isDiscoverable = EnchantmentConfig.discoverableConfig.deathPunk, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.deathPunk,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.deathPunk, canEnchant = EnchantmentConfig.canEnchantConfig.deathPunk, maxLevel = 1
)