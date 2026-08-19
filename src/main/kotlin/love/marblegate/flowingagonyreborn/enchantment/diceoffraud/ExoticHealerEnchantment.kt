package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ExoticHealerEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR,
    pApplicableSlots = EquipmentSlotTypeSet.ARMORS,
    tradableSetting = EnchantmentConfig.tradableConfig.exoticHealer,
    discoverableSetting = EnchantmentConfig.discoverableConfig.exoticHealer,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.exoticHealer,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.exoticHealer,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.exoticHealer,
    maxLevelValue = 2
)