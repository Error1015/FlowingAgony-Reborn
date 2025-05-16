package love.marblegate.flowingagonyreborn.enchantment.flameofenvy

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object CovertKnifeEnchantment : ModBaseEnchantment(
    Rarity.RARE, EnchantmentCategory.BOW, EquipmentSlotTypeSet.MAIN_HAND
) {
    override fun isTradeableConfig(): Boolean = EnchantmentConfig.tradeableConfig.covertKnife.get()

    override fun isDiscoverableConfig(): Boolean = EnchantmentConfig.discoverableConfig.covertKnife.get()

    override fun canApplyAtEnchantingTableConfig(): Boolean = EnchantmentConfig.applyOnEnchantingTableConfig.covertKnife.get()

    override fun getMaxLevel() = 3
}