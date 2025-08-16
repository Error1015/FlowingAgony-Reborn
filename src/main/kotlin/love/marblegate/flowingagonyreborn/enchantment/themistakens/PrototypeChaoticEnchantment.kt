package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.prototypeChaotic,
    discoverableSetting = EnchantmentConfig.discoverableConfig.prototypeChaotic, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaotic,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.prototypeChaotic, canEnchantSetting = EnchantmentConfig.canEnchantConfig.prototypeChaotic, maxLevelValue = 3
)