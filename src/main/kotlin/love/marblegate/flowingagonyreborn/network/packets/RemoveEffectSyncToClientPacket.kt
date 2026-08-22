package love.marblegate.flowingagonyreborn.network.packets

import love.marblegate.flowingagonyreborn.util.asPath
import net.minecraft.core.Holder
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.world.effect.MobEffect
import net.neoforged.neoforge.network.handling.IPayloadContext

data class RemoveEffectSyncToClientPacket(
    val effect: Holder<MobEffect>
) : CustomPacketPayload {
    companion object {
        val codec: StreamCodec<FriendlyByteBuf, RemoveEffectSyncToClientPacket> = StreamCodec.of(
            { buf, packet ->
                buf.writeJsonWithCodec(
                    MobEffect.CODEC,
                    packet.effect
                )
            },
            { buf ->
                RemoveEffectSyncToClientPacket(
                    buf.readJsonWithCodec(MobEffect.CODEC)
                )
            })

        val type = CustomPacketPayload.Type<RemoveEffectSyncToClientPacket>("remove_effect_sync_to_client".asPath)
    }

    override fun type() = type

    fun handle(ctx: IPayloadContext) {
        ctx.enqueueWork { ctx.player().removeEffectNoUpdate(effect) }
    }
}