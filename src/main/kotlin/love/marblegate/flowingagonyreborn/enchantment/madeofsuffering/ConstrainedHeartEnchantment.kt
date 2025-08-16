package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ConstrainedHeartEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.constrainedHeart,
    isDiscoverable = EnchantmentConfig.discoverableConfig.constrainedHeart, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.constrainedHeart,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.constrainedHeart, canEnchant = EnchantmentConfig.canEnchantConfig.constrainedHeart, maxLevel = 1
) {
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != PiercingFeverEnchantment && pOther != DestructionWorshipEnchantment
}