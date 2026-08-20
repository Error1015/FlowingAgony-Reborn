package love.marblegate.flowingagonyreborn.util.proxy

import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.world.effect.MobEffect

interface IProxy {
    fun addParticleForceNear(
        particleData: ParticleOptions, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double
    ) {}

    fun handleISound(
        type: PlaySoundPacket.ModSoundType, onOrOff: Boolean
    ) {}

    fun playSoundWithLocation(
        soundEvent: SoundEvent, category: SoundSource, volume: Float, pitch: Float, x: Double, y: Double, z: Double, distanceDelay: Boolean
    ) {}

    fun removeEffect(effect: MobEffect) {}
}