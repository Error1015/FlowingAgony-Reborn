@file:JvmName("LivingEntityUtil")

package love.marblegate.flowingagonyreborn.util

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
 * 实体是否拥有某项护甲
 */
fun LivingEntity.hasArmor(equipmentSlot: EquipmentSlot) = !this.getItemBySlot(equipmentSlot).isEmpty

fun LivingEntity.hasHelmet() = hasArmor(EquipmentSlot.HEAD)

fun LivingEntity.hasChest() = hasArmor(EquipmentSlot.CHEST)

fun LivingEntity.hasLegs() = hasArmor(EquipmentSlot.LEGS)

fun LivingEntity.hasBoots() = hasArmor(EquipmentSlot.FEET)