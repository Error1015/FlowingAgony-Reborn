package love.marblegate.flowingagonyreborn.network.packets

import love.marblegate.flowingagonyreborn.util.asPath
import net.minecraft.client.Minecraft
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.world.entity.vehicle.Minecart
import net.neoforged.neoforge.network.handling.IPayloadContext

data class AbnormalJoySyncPacket(
    val value: Float
) : CustomPacketPayload {
    companion object {
        val codec: StreamCodec<FriendlyByteBuf, AbnormalJoySyncPacket> = StreamCodec.of(
            { buf, packet -> buf.writeFloat(packet.value) },
                                                                                        { buf -> AbnormalJoySyncPacket(buf.readFloat()) })

        val type = CustomPacketPayload.Type<AbnormalJoySyncPacket>("abnormal_joy_sync".asPath)
    }

    override fun type() = type

    fun handle(ctx: IPayloadContext) {
        ctx.enqueueWork {
                    // val pointCap = Minecraft.getInstance().player?.getCapability(ModCapManager.AbnormalJoy_Capability)
                    // pointCap?.ifPresent(
                    //     NonNullConsumer { cap: AbnormalJoyCapability -> cap.abnormalJoyPoint = value })
        }
    }
}