package love.marblegate.flowingagonyreborn.fx.particle

import com.mojang.brigadier.StringReader
import com.mojang.serialization.Codec
import love.marblegate.flowingagonyreborn.fx.ModParticle
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleType
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn
import java.util.*

@OnlyIn(Dist.CLIENT)
class CursedAntipathyParticle(
    world: ClientLevel, x: Double, y: Double, z: Double, diameter: Float
) : TextureSheetParticle(world, x, y, z) {
    init {
        lifetime = 100
        xd = (Math.random() * 2.0 - 1.0) * 0.1
        yd = 0.0
        zd = (Math.random() * 2.0 - 1.0) * 0.1
        val particleScaleForOneMetre = 0.1f
        quadSize = particleScaleForOneMetre * diameter
        hasPhysics = true
    }

    override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT

    @OnlyIn(Dist.CLIENT)
    class Factory(private val spriteSet: SpriteSet) : ParticleProvider<CursedAntipathyParticleOption> {
        override fun createParticle(
            typeIn: CursedAntipathyParticleOption,
            worldIn: ClientLevel,
            x: Double,
            y: Double,
            z: Double,
            xSpeed: Double,
            ySpeed: Double,
            zSpeed: Double
        ): Particle {
            val cursedHatredParticle = CursedAntipathyParticle(worldIn, x, y, z, typeIn.getDiameter())
            cursedHatredParticle.pickSprite(spriteSet)
            return cursedHatredParticle
        }
    }
}


open class CursedAntipathyParticleOption(
    val diameter: Float
) : ParticleOptions {
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

    override fun getType(): ParticleType<*> = ModParticle.cursedAntipathyParticle

    override fun writeToNetwork(pBuffer: FriendlyByteBuf) {
        pBuffer.writeFloat(diameter)
    }

    override fun writeToString(): String = String.format(Locale.ROOT, "%s %.2f", "cursed_antipathy_particle", diameter)

    fun getDiameter() = diameter
}

object CursedAntipathyParticleType : ParticleType<CursedAntipathyParticleOption>(false, CursedAntipathyParticleOption.DESERIALIZER) {
    override fun codec(): Codec<CursedAntipathyParticleOption> = Codec.unit(CursedAntipathyParticleOption(0f))
}