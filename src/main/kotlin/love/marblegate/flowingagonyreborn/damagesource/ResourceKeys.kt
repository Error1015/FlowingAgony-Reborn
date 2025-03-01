package love.marblegate.flowingagonyreborn.damagesource

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.damagesource.DamageType

object ResourceKeys {
    val curse_hatred = createResourceKey("curse_hatred")
    val cursed_antipathy_effect = createResourceKey("cursed_antipathy_effect")
    val lightburn_fungal_infection = createResourceKey("lightburn_fungal_infection")
    val agony_resonance = createResourceKey("agony_resonance")
    val rhythm_of_universe = createResourceKey("rhythm_of_universe")
    val exotic_healer = createResourceKey("exotic_healer")
    val cutting_watermelon_dream = createResourceKey("cutting_watermelon_dream")

    fun createResourceKey(path: String): ResourceKey<DamageType> {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation(MODID, path))
    }
}