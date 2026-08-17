package love.marblegate.flowingagonyreborn.damagesource

import love.marblegate.flowingagonyreborn.util.asPath
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageType

object ModDamageTypes {
    val cursedHatred = createResourceKey("cursed_hatred")
    val cursedAntipathyEffect = createResourceKey("cursed_antipathy_effect")
    val lightBurnFungalInfection = createResourceKey("lightburn_fungal_infection")
    val agonyResonance = createResourceKey("agony_resonance")
    val rhythmOfUniverse = createResourceKey("rhythm_of_universe")
    val exoticHealer = createResourceKey("exotic_healer")
    val cuttingWatermelonDream = createResourceKey("cutting_watermelon_dream")
    val letMeSavorIt = createResourceKey("let_me_savor_it")
    val burialObjectCurse = createResourceKey("burial_object_curse")
    val phobia = createResourceKey("phobia")

    fun createResourceKey(path: String): ResourceKey<DamageType> = ResourceKey.create(Registries.DAMAGE_TYPE, path.asPath)
}