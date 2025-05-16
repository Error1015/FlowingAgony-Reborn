package love.marblegate.flowingagonyreborn.enchantment.themistakens

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PrototypeChaoticTypeBetaEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlotTypeSet.CHEST
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.prototypeChaoticTypeBeta.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.prototypeChaoticTypeBeta.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.prototypeChaoticTypeBeta.get()

    override fun getMaxLevel() = 1
}