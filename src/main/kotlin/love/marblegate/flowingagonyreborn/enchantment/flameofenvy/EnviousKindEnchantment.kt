package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object EnviousKindEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.enviousKind,
    discoverableSetting = EnchantmentConfig.discoverableConfig.enviousKind,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.enviousKind,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.enviousKind,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.enviousKind,
    maxLevelValue = 1
)