package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object GuidensRegretEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlotTypeSet.ALL
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradableConfig.guidensRegret

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.guidensRegret

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.guidensRegret

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.guidensRegret

    override fun getMaxLevel() = 1

    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != MorirsDeathwishEnchantment && pOther != MorirsLifeboundEnchantment && pOther != Enchantments.MENDING

    override fun isTreasureOnly() = true
}