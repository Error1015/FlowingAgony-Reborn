package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ShadowbornEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, tradableSetting = EnchantmentConfig.tradableConfig.shadowborn,
    discoverableSetting = EnchantmentConfig.discoverableConfig.shadowborn, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.shadowborn,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.shadowborn, canEnchantSetting = EnchantmentConfig.canEnchantConfig.shadowborn, maxLevelValue = 1
)