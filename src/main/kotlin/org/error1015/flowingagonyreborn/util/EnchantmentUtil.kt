@file:JvmName("EnchantmentUtil")

package org.error1015.flowingagonyreborn.util

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment

/**
 * 拓展属性
 */
var LivingEntity.helmet: ItemStack
    get() = this.getItemBySlot(EquipmentSlot.HEAD)
    set(value) = this.setItemSlot(EquipmentSlot.HEAD, value)

var LivingEntity.chestplate: ItemStack
    get() = this.getItemBySlot(EquipmentSlot.CHEST)
    set(value) {
        this.setItemSlot(EquipmentSlot.CHEST, value)
    }

var LivingEntity.leggings: ItemStack
    get() = this.getItemBySlot(EquipmentSlot.LEGS)
    set(value) {
        this.setItemSlot(EquipmentSlot.LEGS, value)
    }

var LivingEntity.boots: ItemStack
    get() = this.getItemBySlot(EquipmentSlot.FEET)
    set(value) {
        this.setItemSlot(EquipmentSlot.FEET, value)
    }

/**
 * 物品是否有某个附魔
 */
fun ItemStack.hasEnchantment(enchantment: Enchantment) = this.allEnchantments.containsKey(enchantment)

/**
 * 获取实体所有护甲
 */
fun LivingEntity.getAllArmors(): List<ItemStack> = listOf(helmet, chestplate, leggings, boots)

/**
 * 获取实体所有护甲是否都拥有一个附魔
 */
fun LivingEntity.allArmorHasEnchantment(enchantment: Enchantment) = this.getAllArmors().all { it.hasEnchantment(enchantment) }

/**
 * 实体有一个护甲拥有某附魔
 */
fun LivingEntity.oneArmorHasEnchantment(enchantment: Enchantment): Boolean {
    getAllArmors().forEach { if (it.hasEnchantment(enchantment)) return true }
    return false
}

/**
 * 实体所有护甲的某附魔数量
 */
fun LivingEntity.getArmorHasEnchantmentCount(enchantment: Enchantment): Int {
    var count = 0
    getAllArmors().forEach { if (it.hasEnchantment(enchantment)) count++ }
    return count
}

/**
 * 实体所有护甲某附魔的总等级
 */
fun LivingEntity.getArmorHasEnchantmentLevel(enchantment: Enchantment): Int {
    var level = 0
    getAllArmors().forEach { level += it.allEnchantments[enchantment] ?: 0 }
    return level
}

/**
 * 实体所有护甲某附魔的最大等级
 */
fun LivingEntity.getArmorHasEnchantmentMaxLevel(enchantment: Enchantment): Int {
    var maxLevel = 0
    getAllArmors().forEach { maxLevel = maxOf(maxLevel, it.allEnchantments[enchantment] ?: 0) }
    return maxLevel
}