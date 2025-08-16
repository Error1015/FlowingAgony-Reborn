package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object InfectiousMaliceEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.infectiousMalice,
    isDiscoverable = EnchantmentConfig.discoverableConfig.infectiousMalice, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.infectiousMalice,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.infectiousMalice, canEnchant = EnchantmentConfig.canEnchantConfig.infectiousMalice, maxLevel = 1
)