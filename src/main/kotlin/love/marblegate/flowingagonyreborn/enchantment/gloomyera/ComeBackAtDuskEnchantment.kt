package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ComeBackAtDuskEnchantment : ModBaseEnchantment(
    pRarity = Rarity.RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, tradableSetting = EnchantmentConfig.tradableConfig.comeBackAtDusk,
    discoverableSetting = EnchantmentConfig.discoverableConfig.comeBackAtDusk, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.comeBackAtDusk,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.comeBackAtDusk, canEnchantSetting = EnchantmentConfig.canEnchantConfig.comeBackAtDusk, maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != DirtyMoneyEnchantment
}