package love.marblegate.flowingagonyreborn.enchantment.madeofmadness

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object InsanePoetEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BOW, pApplicableSlots = EquipmentSlotTypeSet.MAIN_HAND, tradableSetting = EnchantmentConfig.tradableConfig.insanePoet,
    discoverableSetting = EnchantmentConfig.discoverableConfig.insanePoet, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.insanePoet,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.insanePoet, canEnchantSetting = EnchantmentConfig.canEnchantConfig.insanePoet, maxLevelValue = 5
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != AgonyScreamerEnchantment && pOther != Enchantments.POWER_ARROWS && pOther != Enchantments.PUNCH_ARROWS
}