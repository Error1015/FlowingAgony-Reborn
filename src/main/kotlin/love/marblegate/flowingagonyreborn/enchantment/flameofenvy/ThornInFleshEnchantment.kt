package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ThornInFleshEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.CROSSBOW,
    pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND,
    tradableSetting = EnchantmentConfig.tradableConfig.thornInFlesh,
    discoverableSetting = EnchantmentConfig.discoverableConfig.thornInFlesh,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.thornInFlesh,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.thornInFlesh,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.thornInFlesh,
    maxLevelValue = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != EyesoreEnchantment
}