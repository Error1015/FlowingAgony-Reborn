package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object MaliceOutbreakEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, tradableSetting = EnchantmentConfig.tradableConfig.maliceOutbreak,
    discoverableSetting = EnchantmentConfig.discoverableConfig.maliceOutbreak, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.maliceOutbreak,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.maliceOutbreak, canEnchantSetting = EnchantmentConfig.canEnchantConfig.maliceOutbreak, maxLevelValue = 5
)