package love.marblegate.flowingagonyreborn.enchantment.themistakens.curse

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurialObjectCurse : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR,
    pApplicableSlots = EquipmentSlotTypeSet.ARMORS,
    tradableSetting = EnchantmentConfig.tradableConfig.burialObject,
    discoverableSetting = EnchantmentConfig.discoverableConfig.burialObject,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.burialObject,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.burialObject,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.burialObject,
    maxLevelValue = 1
) {
    override fun isCurse() = true
}