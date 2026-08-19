package love.marblegate.flowingagonyreborn.enchantment

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.world.item.*
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.level.block.Block

object CustomEnchantmentCategory {
    val axeAndSwordItem: EnchantmentCategory = EnchantmentCategory.create("$MODID:axe_and_sword") { it is SwordItem || it is AxeItem }
    val swordArmorAndTool: EnchantmentCategory = EnchantmentCategory.create("$MODID:sword_armor_and_tool") { it is ArmorItem || it is TieredItem }
    val bowAndCrossbow: EnchantmentCategory = EnchantmentCategory.create("$MODID:bow_and_crossbow") { it is ProjectileWeaponItem }
    val pickaxe: EnchantmentCategory = EnchantmentCategory.create("$MODID:pickaxe") { it is PickaxeItem }
    val everyThing: EnchantmentCategory = EnchantmentCategory.create("$MODID:everything") {
        it is Vanishable || Block.byItem(it) is Vanishable || EnchantmentCategory.BREAKABLE.canEnchant(it) || EnchantmentCategory.WEARABLE.canEnchant(
            it
        )
    }
}