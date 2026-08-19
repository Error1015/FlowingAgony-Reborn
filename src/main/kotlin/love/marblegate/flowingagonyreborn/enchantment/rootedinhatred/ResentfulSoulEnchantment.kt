package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ResentfulSoulEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_HEAD,
    pApplicableSlots = EquipmentSlotTypeSet.HEAD,
    tradableSetting = EnchantmentConfig.tradableConfig.resentfulSoul,
    discoverableSetting = EnchantmentConfig.discoverableConfig.resentfulSoul,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.resentfulSoul,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.resentfulSoul,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.resentfulSoul,
    maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != TooResentfulToDieEnchantment
}