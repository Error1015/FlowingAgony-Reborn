package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object AgonyScreamerEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BOW, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, isTradable = EnchantmentConfig.tradableConfig.agonyScreamer,
    isDiscoverable = EnchantmentConfig.discoverableConfig.agonyScreamer, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.agonyScreamer,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.agonyScreamer, canEnchant = EnchantmentConfig.canEnchantConfig.agonyScreamer, maxLevel = 3
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != InsanePoetEnchantment
}