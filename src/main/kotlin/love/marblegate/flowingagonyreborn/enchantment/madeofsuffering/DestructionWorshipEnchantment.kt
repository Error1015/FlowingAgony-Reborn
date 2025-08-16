package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DestructionWorshipEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, isTradable = EnchantmentConfig.tradableConfig.destructionWorship,
    isDiscoverable = EnchantmentConfig.discoverableConfig.destructionWorship, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.destructionWorship,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.destructionWorship, canEnchant = EnchantmentConfig.canEnchantConfig.destructionWorship, maxLevel = 1
) {
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != PiercingFeverEnchantment
}