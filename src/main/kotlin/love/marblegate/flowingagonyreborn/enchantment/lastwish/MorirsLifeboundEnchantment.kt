package love.marblegate.flowingagonyreborn.enchantment.lastwish

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.item.enchantment.Enchantments

object MorirsLifeboundEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE, pCategory = EnchantmentCategory.BREAKABLE, pApplicableSlots = EquipmentSlotTypeSet.ALL, isTradable = EnchantmentConfig.tradableConfig.morirsLifebound,
    isDiscoverable = EnchantmentConfig.discoverableConfig.morirsLifebound, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.morirsLifebound,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.morirsLifebound, canEnchant = EnchantmentConfig.canEnchantConfig.morirsLifebound, maxLevel = 1
) {
    override fun checkCompatibility(pOther: Enchantment) =
        super.checkCompatibility(pOther) && pOther != GuidensRegretEnchantment && pOther != Enchantments.MENDING && pOther != MorirsDeathwishEnchantment
}