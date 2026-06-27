package love.marblegate.flowingagonyreborn.fx.particle

import com.mojang.brigadier.StringReader
import love.marblegate.flowingagonyreborn.fx.ModParticle
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleType
import net.minecraft.network.FriendlyByteBuf
import java.util.*

open class CursedAntipathyParticleOption : ParticleOptions {
    private val diameter: Float

    companion object {
        val DESERIALIZER: ParticleOptions.Deserializer<CursedAntipathyParticleOption> = object : ParticleOptions.Deserializer<CursedAntipathyParticleOption> {
            override fun fromCommand(
                pParticleType: ParticleType<CursedAntipathyParticleOption?>, pReader: StringReader
            ): CursedAntipathyParticleOption {
                pReader.expect(' ')
                return CursedAntipathyParticleOption(pReader.readFloat())
            }

            override fun fromNetwork(
                particleType: ParticleType<CursedAntipathyParticleOption>, pBuffer: FriendlyByteBuf
            ): CursedAntipathyParticleOption {
                return CursedAntipathyParticleOption(pBuffer.readFloat())
            }
        }
    }

    constructor(diameter: Float) {
        this.diameter = diameter
    }

    override fun getType(): ParticleType<*> = ModParticle.CURSED_ANTIPATHY_PARTICLE

    override fun writeToNetwork(pBuffer: FriendlyByteBuf) {
        pBuffer.writeFloat(diameter)
    }

    override fun writeToString(): String = String.format(Locale.ROOT, "%s %.2f", "cursed_antipathy_particle", diameter)

    fun getDiameter() = diameter
}