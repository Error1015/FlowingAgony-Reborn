package love.marblegate.flowingagonyreborn.enchantment.rootedinhatred

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object TooResentfulToDieEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR_HEAD, pApplicableSlots = EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.tooResentfulToDie,
    isDiscoverable = EnchantmentConfig.discoverableConfig.tooResentfulToDie, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.tooResentfulToDie,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.tooResentfulToDie, canEnchant = EnchantmentConfig.canEnchantConfig.tooResentfulToDie, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ResentfulSoulEnchantment
}