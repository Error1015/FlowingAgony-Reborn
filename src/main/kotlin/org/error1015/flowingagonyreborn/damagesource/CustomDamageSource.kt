package org.error1015.flowingagonyreborn.damagesource

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.damagesource.DamageType
import org.error1015.flowingagonyreborn.MODID

object CustomDamageSource {
    val type: ResourceKey<DamageType> = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation(MODID, "type"))
}