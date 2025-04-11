package love.marblegate.flowingagonyreborn.network.packet

import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier

class PlaySoundPacket {
    private val type: ModSoundType
    private val onOrOff: Boolean

    companion object {
        var proxy: IProxy = object : IProxy {}
    }

    constructor(buffer: FriendlyByteBuf) {
        type = buffer.readEnum(ModSoundType::class.java)
        onOrOff = buffer.readBoolean()
    }

    constructor(type: ModSoundType, onOrOff: Boolean) {
        this.type = type
        this.onOrOff = onOrOff
    }

    fun toBytes(buffer: FriendlyByteBuf) {
        buffer.writeEnum(type)
        buffer.writeBoolean(onOrOff)
    }

    fun handle(ctx: Supplier<NetworkEvent.Context>) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, Supplier {
            Runnable {
                proxy = ClientProxy()
                ctx.get().enqueueWork({ proxy.handleISound(type, onOrOff) })
                ctx.get().packetHandled = true
            }
        })
    }

    enum class ModSoundType {
        MIRACULOUS_ESCAPE_HEARTBEAT,
        EXTREME_HATRED_FIRST_STAGE,
        EXTREME_HATRED_MEDIUM_STAGE,
        EXTREME_HATRED_FINAL_STAGE
    }
}