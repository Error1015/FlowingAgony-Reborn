package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PiercingFeverEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.piercingFever,
    discoverableSetting = EnchantmentConfig.discoverableConfig.piercingFever, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.piercingFever,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.piercingFever, canEnchantSetting = EnchantmentConfig.canEnchantConfig.piercingFever, maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != DestructionWorshipEnchantment
}