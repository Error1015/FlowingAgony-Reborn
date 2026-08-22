package love.marblegate.flowingagonyreborn.particle

import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object ParticleFactoryRegistry {
    @SubscribeEvent
    fun onParticleFactoryRegistration(event: RegisterParticleProvidersEvent) {
        event.registerSpriteSet(ModParticleRegistrar.cursedAntipathyParticle, { sprites ->
            CursedAntipathyParticle.Factory(sprites)
        })
    }
}