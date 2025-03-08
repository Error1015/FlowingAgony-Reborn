package love.marblegate.flowingagonyreborn.fx

import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.fx.particle.CursedAntipathyParticleType
import net.minecraft.core.particles.ParticleType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModParticle {
    val ParticleTypes: DeferredRegister<ParticleType<*>> = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MODID)
    val CURSED_ANTIPATHY_PARTICLE by ParticleTypes.registerObject("cursed_antipathy_particle") { CursedAntipathyParticleType }
}