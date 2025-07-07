package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object ComeBackAtDuskEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlotTypeSet.ARMORS
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.comeBackAtDusk

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.comeBackAtDusk

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.comeBackAtDusk

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.comeBackAtDusk

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != DirtyMoneyEnchantment
}