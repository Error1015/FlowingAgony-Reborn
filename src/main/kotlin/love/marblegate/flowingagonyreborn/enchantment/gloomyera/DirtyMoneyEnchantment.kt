package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DirtyMoneyEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.dirtyMoney,
    isDiscoverable = EnchantmentConfig.discoverableConfig.dirtyMoney, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.dirtyMoney,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.dirtyMoney, canEnchant = EnchantmentConfig.canEnchantConfig.dirtyMoney, maxLevel = 2
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ComeBackAtDuskEnchantment
}