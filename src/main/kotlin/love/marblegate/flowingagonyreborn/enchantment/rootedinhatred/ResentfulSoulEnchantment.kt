package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ResentfulSoulEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.resentfulSoul,
    isDiscoverable = EnchantmentConfig.discoverableConfig.resentfulSoul, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.resentfulSoul,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.resentfulSoul, canEnchant = EnchantmentConfig.canEnchantConfig.resentfulSoul, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != TooResentfulToDieEnchantment
}