package love.marblegate.flowingagonyreborn.sound

import net.minecraft.client.player.LocalPlayer
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource

class MiraculousEscapeHeartbeatSound(val player: LocalPlayer) : AbstractTickableSoundInstance(
    ModSounds.miraculousEscapeHeartbeat, SoundSource.PLAYERS, RandomSource.create()
) {
    init {
        looping = true
        delay = 0
        volume = 20F
        pitch = 1.0F
    }

    override fun tick() {
        if (!player.isAlive) {
            stop()
        }
    }
}