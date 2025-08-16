package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object PiercingFeverEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.piercingFever,
    isDiscoverable = EnchantmentConfig.discoverableConfig.piercingFever, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.piercingFever,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.piercingFever, canEnchant = EnchantmentConfig.canEnchantConfig.piercingFever, maxLevel = 1
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != DestructionWorshipEnchantment
}