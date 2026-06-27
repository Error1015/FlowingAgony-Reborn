package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object MorirsDeathwishEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BREAKABLE, pApplicableSlots = EquipmentSlotTypeSet.ALL, tradableSetting = EnchantmentConfig.tradableConfig.morirsDeathwish,
    discoverableSetting = EnchantmentConfig.discoverableConfig.morirsDeathwish, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.morirsDeathwish,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.morirsDeathwish, canEnchantSetting = EnchantmentConfig.canEnchantConfig.morirsDeathwish, maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != GuidensRegretEnchantment && pOther != Enchantments.MENDING && pOther != MorirsLifeboundEnchantment
}