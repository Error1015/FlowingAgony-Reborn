@file:JvmName("LivingEntityUtil")

package org.error1015.flowingagonyreborn.util

import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack

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
 * 获取实体所有护甲
 */
fun LivingEntity.getAllArmors(): List<ItemStack> = listOf(helmet, chestplate, leggings, boots)

/**
 * 实体是否拥有某项护甲
 */
fun LivingEntity.hasArmor(equipmentSlot: EquipmentSlot) =
    !this.getItemBySlot(equipmentSlot).isEmpty