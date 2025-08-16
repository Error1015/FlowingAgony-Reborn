package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DirtyMoneyEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, tradableSetting = EnchantmentConfig.tradableConfig.dirtyMoney,
    discoverableSetting = EnchantmentConfig.discoverableConfig.dirtyMoney, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.dirtyMoney,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.dirtyMoney, canEnchantSetting = EnchantmentConfig.canEnchantConfig.dirtyMoney, maxLevelValue = 2
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ComeBackAtDuskEnchantment
}