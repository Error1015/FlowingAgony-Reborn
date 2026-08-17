package love.marblegate.flowingagonyreborn.network.packets

import love.marblegate.flowingagonyreborn.particle.CursedAntipathyParticleOption
import love.marblegate.flowingagonyreborn.util.asPath
import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.core.BlockPos
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.neoforged.neoforge.network.handling.IPayloadContext

class ParticleSyncPacket(
    val effectCategory: MobEffectCategory, val blockPos: BlockPos, val diameter: Float, val count: Int
) : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<out CustomPacketPayload?> = type

    companion object {
        @JvmStatic
        val codec: StreamCodec<FriendlyByteBuf, ParticleSyncPacket> = StreamCodec.of({ buf, packet ->
                                                                                         buf.writeEnum(packet.effectCategory)
                                                                                         buf.writeBlockPos(packet.blockPos)
                                                                                         buf.writeFloat(packet.diameter)
                                                                                         buf.writeInt(packet.count)
                                                                                     }, { buf ->
                                                                                         ParticleSyncPacket(
                                                                                             buf.readEnum(MobEffectCategory::class.java), buf.readBlockPos(), buf.readFloat(), buf.readInt()
                                                                                         )
                                                                                     })

        @JvmStatic
        val type = CustomPacketPayload.Type<ParticleSyncPacket>("particle_sync_to_client".asPath)

        @JvmStatic
        var proxy: IProxy = object : IProxy {}
    }

    fun handle(ctx: IPayloadContext) {
        ctx.enqueueWork {
            ctx.enqueueWork {
                proxy = ClientProxy()

                if (effectCategory == MobEffectCategory.CURSED_ANTIPATHY_EFFECT) {
                    for (i in 0 .. count) {
                        proxy.addParticleForceNear(CursedAntipathyParticleOption(diameter), blockPos.x.toDouble(), blockPos.y.toDouble(), blockPos.z.toDouble(), 0.0, 0.0, 0.0)
                    }
                }
            }
        }
    }

    enum class MobEffectCategory {
        CURSED_ANTIPATHY_EFFECT
    }
}