package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PiercingFeverEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.piercingFever.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.piercingFever.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.piercingFever.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.piercingFever.get()

    override fun getMaxLevel() = 1

    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != DestructionWorshipEnchantment
}