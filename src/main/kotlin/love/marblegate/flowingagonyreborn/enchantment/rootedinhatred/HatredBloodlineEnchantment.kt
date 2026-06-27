package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object HatredBloodlineEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, tradableSetting = EnchantmentConfig.tradableConfig.hatredBloodline,
    discoverableSetting = EnchantmentConfig.discoverableConfig.hatredBloodline, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.hatredBloodline,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.hatredBloodline, canEnchantSetting = EnchantmentConfig.canEnchantConfig.hatredBloodline, maxLevelValue = 3
)