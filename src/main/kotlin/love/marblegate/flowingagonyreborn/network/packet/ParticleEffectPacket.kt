package love.marblegate.flowingagonyreborn.network.packet

import love.marblegate.flowingagonyreborn.fx.particle.CursedAntipathyParticleOption
import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier


class ParticleEffectPacket {
    private val type: MobEffectCategory
    private val x: Double
    private val y: Double
    private val z: Double
    private val args: DoubleArray

    companion object {
        var proxy: IProxy = object : IProxy {}
    }

    constructor(
        type: MobEffectCategory, x: Double, y: Double, z: Double, vararg args: Double
    ) {
        this.type = type
        this.x = x
        this.y = y
        this.z = z
        this.args = args
    }


    constructor(buffer: FriendlyByteBuf) {
        type = buffer.readEnum(MobEffectCategory::class.java)
        x = buffer.readDouble()
        y = buffer.readDouble()
        z = buffer.readDouble()
        val argsSum = buffer.readInt()
        args = DoubleArray(argsSum)
        for (i in 0 ..< argsSum) {
            args[i] = buffer.readDouble()
        }
    }

    fun toBytes(buffer: FriendlyByteBuf) {
        buffer.writeEnum(type)
        buffer.writeDouble(x)
        buffer.writeDouble(y)
        buffer.writeDouble(z)
        buffer.writeInt(args.size)
        for (arg in args) {
            buffer.writeDouble(arg)
        }
    }

    fun handle(ctx: Supplier<NetworkEvent.Context>) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) {
            Runnable {
                ctx.get().let {
                    it.enqueueWork {
                        proxy = ClientProxy()
                        if (type == MobEffectCategory.CURSED_ANTIPATHY_EFFECT) {
                            for (i in 0 .. args[1].toInt()) {
                                proxy.addParticleForceNear(CursedAntipathyParticleOption(args[0].toFloat()), x, y, z, 0.0, 0.0, 0.0)
                            }
                        }
                    }
                    ctx.get().packetHandled = true
                }
            }
        }
    }

    enum class MobEffectCategory {
        CURSED_ANTIPATHY_EFFECT
    }
}