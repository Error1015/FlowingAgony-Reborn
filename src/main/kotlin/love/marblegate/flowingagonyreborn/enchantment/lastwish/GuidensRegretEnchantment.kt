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
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.stubbornStep.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.stubbornStep.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.stubbornStep.get()

    override fun getMaxLevel() = 1

    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != MorirsDeathwishEnchantment && pOther != MorirsLifeboundEnchantment && pOther != Enchantments.MENDING

    override fun isTreasureOnly() = true
}