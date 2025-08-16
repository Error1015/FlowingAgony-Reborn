package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ExoticHealerEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.exoticHealer,
    isDiscoverable = EnchantmentConfig.discoverableConfig.exoticHealer, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.exoticHealer,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.exoticHealer, canEnchant = EnchantmentConfig.canEnchantConfig.exoticHealer, maxLevel = 2
)