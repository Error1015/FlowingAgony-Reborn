package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ComeBackAtDuskEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.comeBackAtDusk,
    isDiscoverable = EnchantmentConfig.discoverableConfig.comeBackAtDusk, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.comeBackAtDusk,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.comeBackAtDusk, canEnchant = EnchantmentConfig.canEnchantConfig.comeBackAtDusk, maxLevel = 1
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != DirtyMoneyEnchantment
}