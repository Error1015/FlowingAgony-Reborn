package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ConstrainedHeartEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.constrainedHeart,
    discoverableSetting = EnchantmentConfig.discoverableConfig.constrainedHeart, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.constrainedHeart,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.constrainedHeart, canEnchantSetting = EnchantmentConfig.canEnchantConfig.constrainedHeart, maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != PiercingFeverEnchantment && pOther != DestructionWorshipEnchantment
}