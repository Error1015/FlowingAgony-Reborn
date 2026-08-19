package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object VengeanceEnchantment : ModBaseEnchantment(
    pRarity = Rarity.VERY_RARE,
    pCategory = EnchantmentCategory.ARMOR_HEAD,
    pApplicableSlots = EquipmentSlotTypeSet.HEAD,
    tradableSetting = EnchantmentConfig.tradableConfig.vengeance,
    discoverableSetting = EnchantmentConfig.discoverableConfig.vengeance,
    canApplyOnEnchantingTableSetting = EnchantmentConfig.applyOnEnchantingTableConfig.vengeance,
    isTreasureOnlySettings = EnchantmentConfig.isTreasureConfig.vengeance,
    canEnchantSetting = EnchantmentConfig.canEnchantConfig.vengeance,
    maxLevelValue = 5
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != PerceivedMaliceEnchantment
}