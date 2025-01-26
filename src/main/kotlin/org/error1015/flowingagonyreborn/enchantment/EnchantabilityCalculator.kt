@file:JvmName("EnchantabilityCalculator")

package org.error1015.flowingagonyreborn.enchantment

import net.minecraft.world.item.enchantment.Enchantment


/**
 * 计算附魔的附魔能力
 */
fun Enchantment.getEnchantability(currentLevel: Int, isMin: Boolean): Int {
    val diff = maxLevel - currentLevel
    return when (rarity.weight) {
        1 -> if (isMin) 30 - 4 * diff else 80 - 10 * diff // VERY RARE
        2 -> if (isMin) 20 - 3 * diff else 70 - 9 * diff // RARE
        5 -> if (isMin) 10 - diff else 60 - 8 * diff // UNCOMMON
        10 -> if (isMin) 1 + currentLevel else 51 - 6 * diff // COMMON
        else -> 1
    }
}