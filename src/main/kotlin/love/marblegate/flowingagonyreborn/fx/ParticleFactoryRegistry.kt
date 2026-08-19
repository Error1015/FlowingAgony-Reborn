package love.marblegate.flowingagonyreborn.fx

import love.marblegate.flowingagonyreborn.fx.particle.CursedAntipathyParticle
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RegisterParticleProvidersEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ParticleFactoryRegistry {
    @SubscribeEvent
    fun onParticleFactoryRegistration(event: RegisterParticleProvidersEvent) {
        event.registerSpriteSet(ModParticle.cursedAntipathyParticle) { CursedAntipathyParticle.Factory(it) }
    }
}