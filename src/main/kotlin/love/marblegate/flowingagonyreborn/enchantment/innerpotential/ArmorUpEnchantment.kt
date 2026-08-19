package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ArmorUpEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.armorUp,
    discoverableSetting = EnchantmentConfig.discoverableConfig.armorUp,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.armorUp,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.armorUp,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.armorUp,
    maxLevelValue = 3
)