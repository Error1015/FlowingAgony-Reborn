package love.marblegate.flowingagonyreborn.enchantment.diceoffraud

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DeathPunkEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON,
    pCategory = EnchantmentCategory.ARMOR_CHEST,
    pApplicableSlots = EquipmentSlotTypeSet.CHEST,
    tradableSetting = EnchantmentConfig.tradableConfig.deathPunk,
    discoverableSetting = EnchantmentConfig.discoverableConfig.deathPunk,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.deathPunk,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.deathPunk,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.deathPunk,
    maxLevelValue = 1
)