package love.marblegate.flowingagonyreborn.enchantment.madeofsuffering

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object DestructionWorshipEnchantment : ModBaseEnchantment(
    pRarity = Rarity.UNCOMMON, pCategory = EnchantmentCategory.ARMOR_CHEST, pApplicableSlots = EquipmentSlotTypeSet.CHEST, tradableSetting = EnchantmentConfig.tradableConfig.destructionWorship,
    discoverableSetting = EnchantmentConfig.discoverableConfig.destructionWorship, canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.destructionWorship,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.destructionWorship, canEnchantSetting = EnchantmentConfig.canEnchantConfig.destructionWorship, maxLevelValue = 1
) {
    override fun checkCompatibility(pOther: Enchantment): Boolean = super.checkCompatibility(pOther) && pOther != ConstrainedHeartEnchantment && pOther != PiercingFeverEnchantment
}