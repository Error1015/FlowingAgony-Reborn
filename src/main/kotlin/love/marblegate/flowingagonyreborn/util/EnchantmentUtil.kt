@file:JvmName("EnchantmentUtil")

package love.marblegate.flowingagonyreborn.util

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.EquipmentSlot.*
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentHelper

/**
 * 物品是否有某个附魔
 */
fun ItemStack.isItemEnchanted(enchantment: Enchantment) = this.allEnchantments.containsKey(enchantment)

/**
 * 获取实体所有护甲是否都拥有一个附魔
 */
fun LivingEntity.allArmorHasEnchantment(enchantment: Enchantment) = this.armorSlots.all { it.isItemEnchanted(enchantment) }

/**
 * 获取实体EquipmentSlot中的附魔
 */
fun LivingEntity.getEnchantmentLevel(
    enchantment: Enchantment, slot: EquipmentSlot
): Int = when (slot) {
    HEAD -> this.helmet.allEnchantments[enchantment] ?: 0
    CHEST -> this.chestplate.allEnchantments[enchantment] ?: 0
    LEGS -> this.leggings.allEnchantments[enchantment] ?: 0
    FEET -> this.boots.allEnchantments[enchantment] ?: 0
    MAINHAND -> this.mainHandItem.allEnchantments[enchantment] ?: 0
    OFFHAND -> offhandItem.allEnchantments[enchantment] ?: 0

}

/**
 * 实体有一个护甲拥有某附魔
 */
fun LivingEntity.anyArmorHasEnchantment(enchantment: Enchantment): Boolean = armorSlots.any { it.isItemEnchanted(enchantment) }

/**
 * 实体所有护甲的某附魔数量
 */
fun LivingEntity.getArmorEnchantmentCount(enchantment: Enchantment): Int {
    var count = 0
    armorSlots.forEach { if (it.isItemEnchanted(enchantment)) count++ }
    return count
}

/**
 * 实体所有护甲某附魔的总等级
 */
fun LivingEntity.getArmorEnchantmentTotalLevel(enchantment: Enchantment): Int {
    var level = 0
    armorSlots.forEach { level += it.allEnchantments[enchantment] ?: 0 }
    return level
}

/**
 * 实体所有护甲某附魔的最大等级
 */
fun LivingEntity.getArmorEnchantmentMaxLevel(enchantment: Enchantment): Int {
    var maxLevel = 0
    armorSlots.forEach { maxLevel = maxOf(maxLevel, it.allEnchantments[enchantment] ?: 0) }
    return maxLevel
}

/**
 * 实体某个槽位是否存在某附魔
 */
fun LivingEntity.isItemEnchanted(
    enchantment: Enchantment, slot: EquipmentSlot
): Boolean {
    val enchantments = EnchantmentHelper.getEnchantments(this.getItemBySlot(slot))
    return enchantments.containsKey(enchantment)
}

fun LivingEntity.getStackWithEnchantment(enchantment: Enchantment): List<ItemStack> {
    val list = mutableListOf<ItemStack>()
    EquipmentSlot.entries.forEach {
        if (this.isItemEnchanted(enchantment, it)) list += getItemBySlot(it)
    }
    return list
}

/**
 * 计算附魔的附魔花费
 */
fun Enchantment.getEnchantability(
    currentLevel: Int, isMin: Boolean
): Int {
    val diff = maxLevel - currentLevel
    return when (rarity.weight) {
        1 -> if (isMin) 30 - 4 * diff else 80 - 10 * diff // VERY RARE
        2 -> if (isMin) 20 - 3 * diff else 70 - 9 * diff // RARE
        5 -> if (isMin) 10 - diff else 60 - 8 * diff // UNCOMMON
        10 -> if (isMin) 1 + currentLevel else 51 - 6 * diff // COMMON
        else -> 1
    }
}