package love.marblegate.flowingagonyreborn.network

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.network.packets.AbnormalJoySyncPacket
import love.marblegate.flowingagonyreborn.network.packets.ParticleSyncPacket
import love.marblegate.flowingagonyreborn.network.packets.RemoveEffectSyncToClientPacket
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ID)
object NetworkPacketRegister {
    @SubscribeEvent
    fun registerPacket(event: RegisterPayloadHandlersEvent) {
        event.registrar("1.0").apply {
            playToClient(AbnormalJoySyncPacket.type, AbnormalJoySyncPacket.codec, AbnormalJoySyncPacket::handle)
            playToClient(RemoveEffectSyncToClientPacket.type, RemoveEffectSyncToClientPacket.codec, RemoveEffectSyncToClientPacket::handle)
            playToClient(ParticleSyncPacket.type, ParticleSyncPacket.codec, ParticleSyncPacket::handle)
        }
    }
}