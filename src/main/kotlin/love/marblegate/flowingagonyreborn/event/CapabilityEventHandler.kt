package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.AbnormalJoySyncPacket
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object CapabilityEventHandler {
    @SubscribeEvent
    fun onbAbnormalJoyCapEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.isCanceled) return
        val causeEntity = event.source.entity ?: return
        if (causeEntity is Player) {
            val pointCap = causeEntity.getCapability(ModCapManager.AbnormalJoy_Capability)
            pointCap.ifPresent { cap ->
                if (cap.getPoint() >= 5) {
                    event.entity.hurt(
                        event.entity
                            .damageSources()
                            .generic(), 15f
                    )
                    cap.decrease(5f)
                } else if (cap.getPoint() <= 1) {
                    cap.decrease(cap.getPoint())
                }

                // 同步到客户端
                val serverPlayer = event.source.entity as? ServerPlayer ?: return@ifPresent
                Networking.safeSend(PacketDistributor.PLAYER.with {
                    serverPlayer
                }, AbnormalJoySyncPacket(cap.getPoint()))
            }
        }
    }
}