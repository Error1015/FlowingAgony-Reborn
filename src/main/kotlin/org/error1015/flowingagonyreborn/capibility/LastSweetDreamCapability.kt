package org.error1015.flowingagonyreborn.capibility

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

class LastSweetDreamCapability(
    private var stack: ItemStack = Items.AIR.defaultInstance
) {
    fun getItemStack() = stack.copy()

    fun saveItemStack(itemStack: ItemStack) {
        stack = itemStack.copy()
    }

    fun clear() {
        stack = Items.AIR.defaultInstance
    }

    fun isEmpty() = stack == Items.AIR.defaultInstance
}