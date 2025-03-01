package love.marblegate.flowingagonyreborn.damagesource

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.damagesource.DamageType

object ResourceKeys {
    val curse_hatred: ResourceKey<DamageType> = createResourceKey("curse_hatred")
    val cursed_antipathy_effect: ResourceKey<DamageType> = createResourceKey("cursed_antipathy_effect")
    val lightburn_fungal_infection: ResourceKey<DamageType> = createResourceKey("lightburn_fungal_infection")
    val agony_resonance: ResourceKey<DamageType> = createResourceKey("agony_resonance")
    val rhythm_of_universe: ResourceKey<DamageType> = createResourceKey("rhythm_of_universe")
    val exotic_healer: ResourceKey<DamageType> = createResourceKey("exotic_healer")

    fun createResourceKey(path: String): ResourceKey<DamageType> {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation(MODID, path))
    }
}