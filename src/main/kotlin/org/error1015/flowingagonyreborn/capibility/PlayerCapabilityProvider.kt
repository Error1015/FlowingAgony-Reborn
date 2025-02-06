package org.error1015.flowingagonyreborn.capibility

import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.common.util.LazyOptional

class PlayerCapabilityProvider : ICapabilitySerializable<CompoundTag> {
    private val abnormalJoyCapability = AbnormalJoyCapability()
    private val abnormalJoyCapabilityOptional = LazyOptional.of { abnormalJoyCapability }
    private val coolDown = CoolDown()
    private val coolDownOptional = LazyOptional.of { coolDown }
    private val hatredBloodlineStatusCapability = HatredBloodlineStatusCapability()
    private val hatredBloodlineStatusCapabilityOptional = LazyOptional.of { hatredBloodlineStatusCapability }
    private val lastSweetDreamCapability = LastSweetDreamCapability()
    private val lastSweetDreamCapabilityOptional = LazyOptional.of { lastSweetDreamCapability }

    fun invalidate() {
        abnormalJoyCapabilityOptional.invalidate()
        coolDownOptional.invalidate()
        hatredBloodlineStatusCapabilityOptional.invalidate()
        lastSweetDreamCapabilityOptional.invalidate()
    }

    override fun <T : Any?> getCapability(cap: Capability<T?>, side: Direction?): LazyOptional<T?> = getCapability(cap)

    override fun <T : Any?> getCapability(cap: Capability<T?>): LazyOptional<T?> {
        if (cap == ModCapManager.AbnormalJoy_Capability) return abnormalJoyCapabilityOptional.cast()
        if (cap == ModCapManager.CoolDown_Capability) return coolDownOptional.cast()
        if (cap == ModCapManager.LastSweetDream_Capability) return lastSweetDreamCapabilityOptional.cast()
        if (cap == ModCapManager.HatredBloodlineStatus_Capability) return hatredBloodlineStatusCapabilityOptional.cast()
        return LazyOptional.empty()
    }

    override fun serializeNBT(): CompoundTag? {
        val nbt = CompoundTag()
        nbt.putFloat("abnormal_joy", abnormalJoyCapability.getPoint())
        CoolDown.CoolDownType.entries.forEach { coolDownType -> nbt.putInt(coolDownType.name, coolDown.get(coolDownType)) }
        nbt.put("last_sweet_dream_itemstack", lastSweetDreamCapability.getItemStack().serializeNBT())
        nbt.putInt("hatred_bloodline_level", hatredBloodlineStatusCapability.getActiveLevel())
        return nbt
    }

    override fun deserializeNBT(nbt: CompoundTag?) {
        if (nbt == null) return
        abnormalJoyCapability.setPoint(nbt.getFloat("abnormal_joy"))
        CoolDown.CoolDownType.entries.forEach { coolDownType -> coolDown.set(coolDownType, nbt.getInt(coolDownType.name)) }
        val nbtItem = nbt.get("last_sweet_dream_itemstack") ?: lastSweetDreamCapability.clear()
        lastSweetDreamCapability.saveItemStack(ItemStack.of(nbtItem as CompoundTag))
        hatredBloodlineStatusCapability.setActiveLevel(nbt.getInt("hatred_bloodline_level"))
    }

}