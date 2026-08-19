package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object GuidensRegretEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.BREAKABLE,
    pApplicableSlots = EquipmentSlotTypeSet.ALL,
    tradableSetting = EnchantmentConfig.tradableConfig.guidensRegret,
    discoverableSetting = EnchantmentConfig.discoverableConfig.guidensRegret,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.guidensRegret,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.guidensRegret,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.guidensRegret,
    maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != MorirsDeathwishEnchantment && pOther != MorirsLifeboundEnchantment && pOther != Enchantments.MENDING
}