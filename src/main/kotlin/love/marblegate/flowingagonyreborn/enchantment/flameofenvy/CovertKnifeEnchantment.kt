package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CovertKnifeEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.BOW, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.covertKnife,
    discoverableSetting = EnchantmentConfig.discoverableConfig.covertKnife, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.covertKnife,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.covertKnife, canEnchantSetting = EnchantmentConfig.canEnchantConfig.covertKnife, maxLevelValue = 3
)