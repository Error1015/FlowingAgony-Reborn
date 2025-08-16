package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CovertKnifeEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.BOW, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.covertKnife,
    isDiscoverable = EnchantmentConfig.discoverableConfig.covertKnife, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.covertKnife,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.covertKnife, canEnchant = EnchantmentConfig.canEnchantConfig.covertKnife, maxLevel = 3
)