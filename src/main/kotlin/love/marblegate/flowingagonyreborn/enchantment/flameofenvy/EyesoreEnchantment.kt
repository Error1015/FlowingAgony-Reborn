package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object EyesoreEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.CROSSBOW, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.eyesore,
    isDiscoverable = EnchantmentConfig.discoverableConfig.eyesore, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.eyesore,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.eyesore, canEnchant = EnchantmentConfig.canEnchantConfig.eyesore, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ThornInFleshEnchantment
}