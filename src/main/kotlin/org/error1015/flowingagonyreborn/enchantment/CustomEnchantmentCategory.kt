package org.error1015.flowingagonyreborn.enchantment

import net.minecraft.world.item.*
import net.minecraft.world.item.enchantment.EnchantmentCategory
import net.minecraft.world.level.block.Block
import org.error1015.flowingagonyreborn.MODID

typealias EnchantmentCategoryArray = Array<EnchantmentCategory>


object CustomEnchantmentCategory {
    val axeAndSwordItem = EnchantmentCategory.create("$MODID:axe_and_sword") { it is SwordItem || it is AxeItem }
    val swordArmorAndTool = EnchantmentCategory.create("$MODID:sword_armor_and_tool") { it is ArmorItem || it is TieredItem }
    val bowAndCrossbow = EnchantmentCategory.create("$MODID:bow_and_crossbow") { it is ProjectileWeaponItem }
    val pickaxe = EnchantmentCategory.create("$MODID:pickaxe") { it is PickaxeItem }
    val evenyThing = EnchantmentCategory.create("$MODID:everything") {
        it is Vanishable || Block.byItem(it) is Vanishable || EnchantmentCategory.BREAKABLE.canEnchant(it) || EnchantmentCategory.WEARABLE.canEnchant(it)
    }

    fun addToItemGroup() {

    }
}