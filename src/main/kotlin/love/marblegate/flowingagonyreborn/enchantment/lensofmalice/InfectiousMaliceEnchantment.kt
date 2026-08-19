package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object InfectiousMaliceEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR,
    pApplicableSlots = EquipmentSlotTypeSet.ARMORS,
    tradableSetting = EnchantmentConfig.tradableConfig.infectiousMalice,
    discoverableSetting = EnchantmentConfig.discoverableConfig.infectiousMalice,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.infectiousMalice,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.infectiousMalice,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.infectiousMalice,
    maxLevelValue = 1
)