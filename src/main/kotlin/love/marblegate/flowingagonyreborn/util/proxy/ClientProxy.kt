package love.marblegate.flowingagonyreborn.util.proxy

import love.marblegate.flowingagonyreborn.network.packets.PlaySoundPacket
import love.marblegate.flowingagonyreborn.sound.ExtremeHatredFinalStageSound
import love.marblegate.flowingagonyreborn.sound.ExtremeHatredFirstStageSound
import love.marblegate.flowingagonyreborn.sound.ExtremeHatredMediumStageSound
import love.marblegate.flowingagonyreborn.sound.MiraculousEscapeHeartbeatSound
import love.marblegate.flowingagonyreborn.sound.ModSounds
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.Holder
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.level.Level


class ClientProxy : IProxy {
    override fun addParticleForceNear(
        particleData: ParticleOptions, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double
    ) {
        val level: Level = Minecraft.getInstance().level ?: return
        val info = Minecraft.getInstance().gameRenderer.mainCamera
        if (info.isInitialized && info.position.distanceToSqr(x, y, z) <= 512.0) {
            level.addParticle(particleData, true, x, y, z, xSpeed, ySpeed, zSpeed)
        }
    }

    override fun handleISound(
        type: PlaySoundPacket.ModSoundType, onOrOff: Boolean
    ) {
        val soundManager = Minecraft.getInstance().soundManager
        when (type) {
            PlaySoundPacket.ModSoundType.MiraculousEscape -> {
                if (onOrOff) {
                    soundManager.stop(ModSounds.miraculousEscapeHeartbeat.location, SoundSource.PLAYERS)
                    soundManager.play(MiraculousEscapeHeartbeatSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    Minecraft.getInstance().soundManager.stop(ModSounds.miraculousEscapeHeartbeat.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.ExtremeHatredFirst -> {
                if (onOrOff) {
                    soundManager.play(ExtremeHatredFirstStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    soundManager.stop(ModSounds.extremeHatredFirstStageSound.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.ExtremeHatredMedium -> {
                if (onOrOff) {
                    soundManager.stop(ModSounds.extremeHatredMediumStageSound.location, SoundSource.PLAYERS)
                    soundManager.play(ExtremeHatredMediumStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    soundManager.stop(ModSounds.extremeHatredMediumStageSound.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.ExtremeHatredFinal -> {
                if (onOrOff) {
                    soundManager.stop(ModSounds.extremeHatredFinalStageSound.location, SoundSource.PLAYERS)
                    soundManager.play(ExtremeHatredFinalStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    soundManager.stop(ModSounds.extremeHatredFinalStageSound.location, SoundSource.PLAYERS)
                }
            }
        }
    }

    override fun playSoundWithLocation(
        soundEvent: SoundEvent, category: SoundSource, volume: Float, pitch: Float, x: Double, y: Double, z: Double, distanceDelay: Boolean
    ) {
        val level = Minecraft.getInstance().level ?: return
        level.playLocalSound(x, y, z, soundEvent, category, volume, pitch, distanceDelay)
    }

    override fun removeEffect(effect: Holder<MobEffect>) {
        val player = Minecraft.getInstance().player ?: return
        player.removeEffectNoUpdate(effect)
    }
}