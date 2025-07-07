package love.marblegate.flowingagonyreborn.network

import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.network.packet.*
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.network.NetworkDirection
import net.minecraftforge.network.NetworkRegistry
import net.minecraftforge.network.simple.SimpleChannel
import java.util.*

object Networking {
    lateinit var instance: SimpleChannel private set
    const val VERSION: String = "1.0"
    var ID: Int = 0

    fun nextID() = ++ID

    fun isInstanceInitialized() = ::instance.isInitialized

    fun registerMessage() {
        instance = NetworkRegistry.newSimpleChannel(ResourceLocation(MODID, "mod_networking"), { VERSION }, { true }, { true })
        instance.registerMessage(nextID(), PlaySoundPacket::class.java, PlaySoundPacket::toBytes, ::PlaySoundPacket, PlaySoundPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT))
        instance.registerMessage(
            nextID(), ParticleEffectPacket::class.java, ParticleEffectPacket::toBytes, ::ParticleEffectPacket, ParticleEffectPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        )
        instance.registerMessage(
            nextID(), PlaySoundWithLocationPacket::class.java, PlaySoundWithLocationPacket::toBytes, ::PlaySoundWithLocationPacket, PlaySoundWithLocationPacket::handle,
            Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        )
        instance.registerMessage(
            nextID(), AbnormalJoySyncPacket::class.java, AbnormalJoySyncPacket::toBytes, ::AbnormalJoySyncPacket, AbnormalJoySyncPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        )
        instance.registerMessage(
            nextID(), RemoveEffectSyncToClientPacket::class.java, RemoveEffectSyncToClientPacket::toBytes, ::RemoveEffectSyncToClientPacket, RemoveEffectSyncToClientPacket::handle,
            Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        )
    }
}