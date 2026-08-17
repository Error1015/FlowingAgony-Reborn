package love.marblegate.flowingagonyreborn.util.proxy

import net.minecraft.client.Minecraft
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

    // override fun handleISound(
    //     type: PlaySoundPacket.ModSoundType, onOrOff: Boolean
    // ) {
    //     when (type) {
    //         PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT -> {
    //             if (onOrOff) {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.MIRACULOUS_ESCAPE_HEARTBEAT.location, SoundSource.PLAYERS)
    //                 Minecraft.getInstance().soundManager.play(MiraculousEscapeHeartbeatSound(Minecraft.getInstance().player as LocalPlayer))
    //             } else {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.MIRACULOUS_ESCAPE_HEARTBEAT.location, SoundSource.PLAYERS)
    //             }
    //         }
    //
    //         PlaySoundPacket.ModSoundType.EXTREME_HATRED_FIRST_STAGE -> {
    //             if (onOrOff) {
    //                 Minecraft.getInstance().soundManager.play(ExtremeHatredFirstStageSound(Minecraft.getInstance().player as LocalPlayer))
    //             } else {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.EXTREME_HATRED_FIRST_STAGE_SOUND.location, SoundSource.PLAYERS)
    //             }
    //         }
    //
    //         PlaySoundPacket.ModSoundType.EXTREME_HATRED_MEDIUM_STAGE -> {
    //             if (onOrOff) {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.EXTREME_HATRED_FIRST_STAGE_SOUND.location, SoundSource.PLAYERS)
    //                 Minecraft.getInstance().soundManager.play(ExtremeHatredMediumStageSound(Minecraft.getInstance().player as LocalPlayer))
    //             } else {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.EXTREME_HATRED_MEDIUM_STAGE_SOUND.location, SoundSource.PLAYERS)
    //             }
    //         }
    //
    //         PlaySoundPacket.ModSoundType.EXTREME_HATRED_FINAL_STAGE -> {
    //             if (onOrOff) {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.EXTREME_HATRED_MEDIUM_STAGE_SOUND.location, SoundSource.PLAYERS)
    //                 Minecraft.getInstance().soundManager.play(ExtremeHatredFinalStageSound(Minecraft.getInstance().player as LocalPlayer))
    //             } else {
    //                 Minecraft.getInstance().soundManager.stop(ModSounds.EXTREME_HATRED_FINAL_STAGE_SOUND.location, SoundSource.PLAYERS)
    //             }
    //         }
    //     }
    // }

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