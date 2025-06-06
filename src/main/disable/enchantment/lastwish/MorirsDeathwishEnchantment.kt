package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object MorirsDeathwishEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlotTypeSet.ALL
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.morirsDeathwish.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.morirsDeathwish.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.morirsDeathwish.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.morirsDeathwish.get()

    override fun getMaxLevel() = 1

    override fun isTreasureOnly() = true

    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != GuidensRegretEnchantment && pOther != Enchantments.MENDING && pOther != MorirsLifeboundEnchantment
}