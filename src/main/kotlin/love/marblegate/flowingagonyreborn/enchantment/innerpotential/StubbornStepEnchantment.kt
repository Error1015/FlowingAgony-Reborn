package love.marblegate.flowingagonyreborn.enchantment.innerpotential

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object StubbornStepEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON,
    pCategory = EnchantmentCategory.ARMOR_FEET,
    pApplicableSlots = EquipmentSlotTypeSet.FEET,
    tradableSetting = EnchantmentConfig.tradableConfig.stubbornStep,
    discoverableSetting = EnchantmentConfig.discoverableConfig.stubbornStep,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.stubbornStep,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.stubbornStep,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.stubbornStep,
    maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != FrivolousStepEnchantment
}