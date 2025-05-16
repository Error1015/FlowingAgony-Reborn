package love.marblegate.flowingagonyreborn.fx.sound

import love.marblegate.flowingagonyreborn.fx.ModSounds
import net.minecraft.client.player.LocalPlayer
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource

class MiraculousEscapeHeartbeatSound : AbstractTickableSoundInstance {
    private val player: LocalPlayer

    constructor(player: LocalPlayer) : super(ModSounds.MIRACULOUS_ESCAPE_HEARTBEAT, SoundSource.PLAYERS, RandomSource.create()) {
        this.player = player
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