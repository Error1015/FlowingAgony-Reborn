package love.marblegate.flowingagonyreborn.network.packet

import love.marblegate.flowingagonyreborn.capibility.AbnormalJoyCapability
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import net.minecraft.client.Minecraft
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.util.NonNullConsumer
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier


class AbnormalJoySyncPacket {
    private val value: Float

    constructor(value: Float) {
        this.value = value
    }

    constructor(buffer: FriendlyByteBuf) {
        value = buffer.readFloat()
    }

    fun toBytes(buffer: FriendlyByteBuf) {
        buffer.writeFloat(value)
    }

    fun handle(ctx: Supplier<NetworkEvent.Context>) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) {
            Runnable {
                ctx.get().let {
                    it.enqueueWork {
                        val pointCap = Minecraft.getInstance().player?.getCapability(ModCapManager.AbnormalJoy_Capability)
                        pointCap?.ifPresent(
                            NonNullConsumer { cap: AbnormalJoyCapability? -> cap?.setPoint(value) })
                        ctx.get().packetHandled = true
                    }
                }
            }
        }
    }
}