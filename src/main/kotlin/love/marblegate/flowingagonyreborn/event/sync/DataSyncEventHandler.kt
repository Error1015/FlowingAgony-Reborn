package love.marblegate.flowingagonyreborn.event.sync

import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.AbnormalJoySyncPacket
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object DataSyncEventHandler {
    @SubscribeEvent
    fun syncDataWhenLogging(event: PlayerEvent.PlayerLoggedInEvent) {
        syncAbnormalJoyCapability(event.entity)
    }

    @SubscribeEvent
    fun syncDataWhenChangeDimension(event: PlayerEvent.PlayerChangedDimensionEvent) {
        syncAbnormalJoyCapability(event.entity)
    }

    @SubscribeEvent
    fun syncDataWhenRespawn(event: PlayerEvent.PlayerRespawnEvent) {
        syncAbnormalJoyCapability(event.entity)
    }

    fun syncAbnormalJoyCapability(player: Player) {
        if (player.level().isClientSide || !Networking.isInitialized()) return

        player.getCapability(ModCapManager.AbnormalJoy_Capability).resolve().let { cap ->
            (player as? ServerPlayer)?.let { serverPlayer ->
                Networking.INSTANCE.send(
                    PacketDistributor.PLAYER.with { serverPlayer }, AbnormalJoySyncPacket(cap.get().getPoint())
                )
            }
        }
    }
}