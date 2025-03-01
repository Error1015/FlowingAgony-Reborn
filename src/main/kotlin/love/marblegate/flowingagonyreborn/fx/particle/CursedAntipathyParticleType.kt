package love.marblegate.flowingagonyreborn.fx.particle

import com.mojang.serialization.Codec
import net.minecraft.core.particles.ParticleType

object CursedAntipathyParticleType : ParticleType<CursedAntipathyParticleOption>(false, CursedAntipathyParticleOption.DESERIALIZER) {
    override fun codec(): Codec<CursedAntipathyParticleOption> = Codec.unit(CursedAntipathyParticleOption(0f))
}