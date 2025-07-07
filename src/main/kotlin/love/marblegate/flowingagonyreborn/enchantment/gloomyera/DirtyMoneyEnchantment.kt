package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DirtyMoneyEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.dirtyMoney

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.dirtyMoney

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.dirtyMoney

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.dirtyMoney

    override fun getMaxLevel() = 2

    override fun isTreasureOnly() = true

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ComeBackAtDuskEnchantment
}