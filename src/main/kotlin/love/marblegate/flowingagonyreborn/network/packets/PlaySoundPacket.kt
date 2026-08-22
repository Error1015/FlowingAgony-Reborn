package love.marblegate.flowingagonyreborn.network.packets

import love.marblegate.flowingagonyreborn.util.asPath
import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.neoforged.neoforge.network.handling.IPayloadContext

class PlaySoundPacket(
    val soundType: ModSoundType,
    val isOn: Boolean,
) : CustomPacketPayload {
    override fun type() = type


    companion object {
        val codec: StreamCodec<FriendlyByteBuf, PlaySoundPacket> = StreamCodec.of({ buf, packet ->
                                                                                      buf.writeEnum(packet.soundType)
                                                                                      buf.writeBoolean(packet.isOn)
                                                                                  }, { buf ->
                                                                                      PlaySoundPacket(
                                                                                          buf.readEnum(ModSoundType::class.java), buf.readBoolean()
                                                                                      )
                                                                                  })

        val type = CustomPacketPayload.Type<PlaySoundPacket>("play_sound".asPath)

        var proxy: IProxy = object : IProxy {}

    }

    fun handle(ctx: IPayloadContext) {
        proxy = ClientProxy()
        ctx.enqueueWork {
            proxy.handleISound(soundType, isOn)
        }
    }

    enum class ModSoundType {
        MiraculousEscape,
        ExtremeHatredFirst,
        ExtremeHatredMedium,
        ExtremeHatredFinal
    }
}