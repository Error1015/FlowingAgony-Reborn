package love.marblegate.flowingagonyreborn.enchantment.themistakens.curse

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object BurialObjectCurse : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.ARMOR, pApplicableSlots = EquipmentSlotTypeSet.ARMORS, isTradable = EnchantmentConfig.tradableConfig.burialObject,
    isDiscoverable = EnchantmentConfig.discoverableConfig.burialObject, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.burialObject,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.burialObject, canEnchant = EnchantmentConfig.canEnchantConfig.burialObject, maxLevel = 1
) {
    override fun isCurse() = true
}