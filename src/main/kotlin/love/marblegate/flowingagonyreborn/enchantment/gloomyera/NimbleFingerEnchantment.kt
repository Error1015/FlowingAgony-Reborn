package love.marblegate.flowingagonyreborn.enchantment.gloomyera

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.CustomEnchantmentCategory
import love.marblegate.flowingagonyreborn.enchantment.EquipmentSlotTypeSet
import love.marblegate.flowingagonyreborn.enchantment.ModBaseEnchantment

object NimbleFingerEnchantment : ModBaseEnchantment(
    Rarity.RARE, CustomEnchantmentCategory.swordArmorAndTool, EquipmentSlotTypeSet.ALL
) {
    override fun getConfig(): Boolean = Config.acquirableSettings.nimbleFinger.get()
    override fun getMaxLevel() = 3
}