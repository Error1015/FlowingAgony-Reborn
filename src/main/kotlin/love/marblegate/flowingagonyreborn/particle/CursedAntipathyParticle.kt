package love.marblegate.flowingagonyreborn.particle

import com.mojang.serialization.MapCodec
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleType
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.neoforged.api.distmarker.Dist
import net.neoforged.api.distmarker.OnlyIn

class CursedAntipathyParticle(
    val world: ClientLevel, x: Double, y: Double, z: Double, diameter: Float
) : TextureSheetParticle(world, x, y, z) {
    override fun getRenderType(): ParticleRenderType = ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT

    init {
        lifetime = 100
        xd = (Math.random() * 2.0 - 1.0) * 0.1
        yd = 0.0
        zd = (Math.random() * 2.0 - 1.0) * 0.1
        val particleScaleForOneMetre = 0.1f
        quadSize = particleScaleForOneMetre * diameter
        hasPhysics = true
    }


    @OnlyIn(Dist.CLIENT)
    class Factory(val spriteSet: SpriteSet) : ParticleProvider<CursedAntipathyParticleOption> {
        override fun createParticle(
            typeIn: CursedAntipathyParticleOption, worldIn: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double
        ): TextureSheetParticle {
            val cursedHatredParticle = CursedAntipathyParticle(worldIn, x, y, z, typeIn.diameter)
            cursedHatredParticle.pickSprite(spriteSet)
            return cursedHatredParticle
        }
    }
}

class CursedAntipathyParticleOption(val diameter: Float) : ParticleOptions {
    override fun getType(): ParticleType<*> {
        return ModParticleRegistrar.cursedAntipathyParticle
    }
}

object CursedAntipathyParticleType : ParticleType<CursedAntipathyParticleOption>(false) {
    override fun codec(): MapCodec<CursedAntipathyParticleOption?> {
        return MapCodec.unit(CursedAntipathyParticleOption(0f))
    }

    override fun streamCodec(): StreamCodec<in RegistryFriendlyByteBuf, CursedAntipathyParticleOption?> {
        return StreamCodec.unit(CursedAntipathyParticleOption(0f))
    }
}