package love.marblegate.flowingagonyreborn.util.proxy

import love.marblegate.flowingagonyreborn.fx.ModSounds
import love.marblegate.flowingagonyreborn.fx.sound.ExtremeHatredFinalStageSound
import love.marblegate.flowingagonyreborn.fx.sound.ExtremeHatredFirstStageSound
import love.marblegate.flowingagonyreborn.fx.sound.ExtremeHatredMediumStageSound
import love.marblegate.flowingagonyreborn.fx.sound.MiraculousEscapeHeartbeatSound
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.level.Level


class ClientProxy : IProxy {
    override fun addParticleForceNear(
        particleData: ParticleOptions, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double
    ) {
        val world: Level = Minecraft.getInstance().level ?: return
        val info = Minecraft.getInstance().gameRenderer.mainCamera
        if (info.isInitialized && info.position.distanceToSqr(x, y, z) <= 512.0) {
            world.addParticle(particleData, true, x, y, z, xSpeed, ySpeed, zSpeed)
        }
    }

    override fun handleISound(
        type: PlaySoundPacket.ModSoundType, onOrOff: Boolean
    ) {
        when (type) {
            PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT -> {
                if (onOrOff) {
                    Minecraft.getInstance().soundManager.stop(ModSounds.miraculousEscapeHeartbeat.location, SoundSource.PLAYERS)
                    Minecraft.getInstance().soundManager.play(MiraculousEscapeHeartbeatSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    Minecraft.getInstance().soundManager.stop(ModSounds.miraculousEscapeHeartbeat.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.EXTREME_HATRED_FIRST_STAGE -> {
                if (onOrOff) {
                    Minecraft.getInstance().soundManager.play(ExtremeHatredFirstStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    Minecraft.getInstance().soundManager.stop(ModSounds.extremeHatredFirstStageSound.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.EXTREME_HATRED_MEDIUM_STAGE -> {
                if (onOrOff) {
                    Minecraft.getInstance().soundManager.stop(ModSounds.extremeHatredFirstStageSound.location, SoundSource.PLAYERS)
                    Minecraft.getInstance().soundManager.play(ExtremeHatredMediumStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    Minecraft.getInstance().soundManager.stop(ModSounds.extremeHatredMediumStageSound.location, SoundSource.PLAYERS)
                }
            }

            PlaySoundPacket.ModSoundType.EXTREME_HATRED_FINAL_STAGE -> {
                if (onOrOff) {
                    Minecraft.getInstance().soundManager.stop(ModSounds.extremeHatredMediumStageSound.location, SoundSource.PLAYERS)
                    Minecraft.getInstance().soundManager.play(ExtremeHatredFinalStageSound(Minecraft.getInstance().player as LocalPlayer))
                } else {
                    Minecraft.getInstance().soundManager.stop(ModSounds.extremeHatredFinalStageSound.location, SoundSource.PLAYERS)
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

    override fun removeEffect(effect: MobEffect) {
        val player = Minecraft.getInstance().player ?: return
        player.removeEffectNoUpdate(effect)
    }
}