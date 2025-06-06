package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DestructionWorshipEnchantment : ModBaseEnchantment(
    Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradableConfig(): Boolean = EnchantmentConfig.tradeableConfig.destructionWorship.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.destructionWorship.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.destructionWorship.get()

    override fun isTreasureOnlyConfig(): Boolean = EnchantmentConfig.isTreasureConfig.destructionWorship.get()

    override fun getMaxLevel() = 1

    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != PiercingFeverEnchantment
}