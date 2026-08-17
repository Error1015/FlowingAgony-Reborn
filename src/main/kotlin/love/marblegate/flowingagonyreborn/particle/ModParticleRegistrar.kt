package love.marblegate.flowingagonyreborn.particle

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.core.particles.ParticleType
import net.minecraft.core.registries.BuiltInRegistries
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModParticleRegistrar {
    val registries: DeferredRegister<ParticleType<*>> = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ID)
    val cursedAntipathyParticle: CursedAntipathyParticleType by registries.register("cursed_antipathy_particle") { -> CursedAntipathyParticleType }
}