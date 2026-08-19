package love.marblegate.flowingagonyreborn.network.packet

import love.marblegate.flowingagonyreborn.util.proxy.ClientProxy
import love.marblegate.flowingagonyreborn.util.proxy.IProxy
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.effect.MobEffect
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.network.NetworkEvent
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier


class RemoveEffectSyncToClientPacket {
    private val effect: MobEffect

    companion object {
        var proxy: IProxy = object : IProxy {}
    }

    constructor(effect: MobEffect) {
        this.effect = effect
    }

    constructor(buffer: FriendlyByteBuf) {
        effect = buffer.readRegistryIdSafe(MobEffect::class.java)
    }


    fun toBytes(buffer: FriendlyByteBuf) {
        buffer.writeRegistryId(ForgeRegistries.MOB_EFFECTS, effect)
    }

    fun handle(ctx: Supplier<NetworkEvent.Context>) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) {
            Runnable {
                ctx.get().let {
                    it.enqueueWork {
                        proxy = ClientProxy()
                        proxy.removeEffect(effect)
                    }
                    ctx.get().packetHandled = true
                }
            }
        }
    }
}