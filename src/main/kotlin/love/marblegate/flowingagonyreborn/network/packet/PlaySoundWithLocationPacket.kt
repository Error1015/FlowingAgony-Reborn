package love.marblegate.flowingagonyreborn.network.packet

import love.marblegate.flowingagonyreborn.fx.ModSounds
import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.sounds.SoundSource
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier

class PlaySoundWithLocationPacket {
    private val type: ModSoundType
    private var onOrOff = false
    private val x: Double
    private val y: Double
    private val z: Double

    companion object {
        var proxy: IProxy = object : IProxy {}
    }

    constructor(
        type: ModSoundType,
        onOrOff: Boolean,
        x: Double,
        y: Double,
        z: Double
    ) {
        this.type = type
        this.onOrOff = onOrOff
        this.x = x
        this.y = y
        this.z = z
    }

    constructor(buffer: FriendlyByteBuf) {
        type = buffer.readEnum(ModSoundType::class.java)
        onOrOff = buffer.readBoolean()
        x = buffer.readDouble()
        y = buffer.readDouble()
        z = buffer.readDouble()
    }

    fun toBytes(buffer: FriendlyByteBuf) {
        buffer.writeEnum(type)
        buffer.writeBoolean(onOrOff)
        buffer.writeDouble(x)
        buffer.writeDouble(y)
        buffer.writeDouble(z)
    }

    fun handle(ctx: Supplier<NetworkEvent.Context>) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) {
            proxy = ClientProxy()
            Runnable {
                ctx
                    .get()
                    .let {
                        it.enqueueWork {
                            if (type == ModSoundType.MALICE_OUTBREAK_KNOCKBACK_SOUND) {
                                proxy.playSoundWithLocation(ModSounds.MALICE_OUTBREAK_KNOCKBACK_SOUND, SoundSource.PLAYERS, 5f, 0.5f, x, y, z, true)
                            }
                        }
                        ctx.get().packetHandled = true
                    }
            }
        }
    }

    enum class ModSoundType {
        MALICE_OUTBREAK_KNOCKBACK_SOUND
    }
}