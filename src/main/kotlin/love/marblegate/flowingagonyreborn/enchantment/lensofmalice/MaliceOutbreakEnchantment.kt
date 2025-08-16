package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MaliceOutbreakEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.maliceOutbreak,
    isDiscoverable = EnchantmentConfig.discoverableConfig.maliceOutbreak, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.maliceOutbreak,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.maliceOutbreak, canEnchant = EnchantmentConfig.canEnchantConfig.maliceOutbreak, maxLevel = 5
)