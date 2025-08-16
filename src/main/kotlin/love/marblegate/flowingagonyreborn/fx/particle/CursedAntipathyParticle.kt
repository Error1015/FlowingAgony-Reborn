package love.marblegate.flowingagonyreborn.fx.particle

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

@OnlyIn(Dist.CLIENT)
class CursedAntipathyParticle : TextureSheetParticle {
    constructor(
        world: ClientLevel, x: Double, y: Double, z: Double, diameter: Float
    ) : super(world, x, y, z) {
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
            typeIn: CursedAntipathyParticleOption, worldIn: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double
        ): Particle {
            val cursedHatredParticle = CursedAntipathyParticle(worldIn, x, y, z, typeIn.getDiameter())
            cursedHatredParticle.pickSprite(spriteSet)
            return cursedHatredParticle
        }
    }
}