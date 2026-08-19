package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticTypeBetaEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.prototypeChaoticTypeBeta,
    discoverableSetting = EnchantmentConfig.discoverableConfig.prototypeChaoticTypeBeta,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaoticTypeBeta,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.prototypeChaoticTypeBeta,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.prototypeChaoticTypeBeta,
    maxLevelValue = 1
)