package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object AgonyScreamerEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.agonyScreamer.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.agonyScreamer.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.agonyScreamer.get()

    override fun getMaxLevel() = 3

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != InsanePoetEnchantment
}