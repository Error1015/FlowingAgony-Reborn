package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object InsanePoetEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.insanePoet,
    isDiscoverable = EnchantmentConfig.discoverableConfig.insanePoet, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.insanePoet,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.insanePoet, canEnchant = EnchantmentConfig.canEnchantConfig.insanePoet, maxLevel = 5
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != AgonyScreamerEnchantment && pOther != Enchantments.POWER_ARROWS && pOther != Enchantments.PUNCH_ARROWS
}