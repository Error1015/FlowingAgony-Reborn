package love.marblegate.flowingagonyreborn.enchantment.lensofmalice

import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

object VengeanceEnchantment : ModBaseEnchantment(
    Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlotTypeSet.HEAD, isTradable = EnchantmentConfig.tradableConfig.vengeance,
    isDiscoverable = EnchantmentConfig.discoverableConfig.vengeance, canApplyOnEnchantingTable = EnchantmentConfig.applyOnEnchantingTableConfig.vengeance,
    isTreasureOnly = EnchantmentConfig.isTreasureConfig.vengeance, canEnchant = EnchantmentConfig.canEnchantConfig.vengeance, maxLevel = 5
) {
    override fun checkCompatibility(pOther: Enchantment) = super.checkCompatibility(pOther) && pOther != PerceivedMaliceEnchantment
}