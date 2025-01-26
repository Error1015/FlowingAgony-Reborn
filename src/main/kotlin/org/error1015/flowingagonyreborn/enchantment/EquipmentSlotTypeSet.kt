package org.error1015.flowingagonyreborn.enchantment

import net.minecraft.world.entity.EquipmentSlot

object EquipmentSlotTypeSet {
    val HEAD: Array<EquipmentSlot> = arrayOf(EquipmentSlot.HEAD)
    val CHEST: Array<EquipmentSlot> = arrayOf(EquipmentSlot.CHEST)
    val LEGS: Array<EquipmentSlot> = arrayOf(EquipmentSlot.LEGS)
    val FEET: Array<EquipmentSlot> = arrayOf(EquipmentSlot.FEET)
    val MAIN_HAND: Array<EquipmentSlot> = arrayOf(EquipmentSlot.MAINHAND)
    val ARMORS: Array<EquipmentSlot> = arrayOf(EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET)
    val ALL: Array<EquipmentSlot> = EquipmentSlot.entries.toTypedArray()
}