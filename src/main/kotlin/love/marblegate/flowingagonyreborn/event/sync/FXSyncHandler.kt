package love.marblegate.flowingagonyreborn.event.sync

import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object FXSyncHandler {
    @SubscribeEvent
    fun fixFXWhenChangeDimension(event: PlayerEvent.PlayerChangedDimensionEvent) {
        reapplyFX(event.entity)
    }

    @SubscribeEvent
    fun fixFXWhenLogging(event: PlayerLoggedInEvent) {
        reapplyFX(event.entity)
    }

    fun reapplyFX(player: Player) {
        if (player.level().isClientSide) return
        val serverPlayer = player as? ServerPlayer ?: return
        when {
            player.hasEffect(ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE) -> {
                Networking.safeSend(
                    PacketDistributor.PLAYER.with { serverPlayer },
                                    PlaySoundPacket(PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT, true)
                )
            }

            player.hasEffect(ModEffects.EXTREME_HATRED) -> {
                val temp = player.getEffect(ModEffects.EXTREME_HATRED)?.amplifier ?: 0
                when (temp) {
                    0 -> Networking.safeSend(
                        PacketDistributor.PLAYER.with { serverPlayer }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FIRST_STAGE, true)
                    )


                    1 -> Networking.safeSend(
                        PacketDistributor.PLAYER.with { serverPlayer },
                        PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_MEDIUM_STAGE, true)
                    )


                    2 -> Networking.safeSend(
                        PacketDistributor.PLAYER.with { serverPlayer }, PlaySoundPacket(PlaySoundPacket.ModSoundType.EXTREME_HATRED_FINAL_STAGE, true)
                    )
                }
            }
        }
    }
}