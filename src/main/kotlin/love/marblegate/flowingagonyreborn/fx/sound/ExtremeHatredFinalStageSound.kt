package love.marblegate.flowingagonyreborn.fx.sound

import love.marblegate.flowingagonyreborn.fx.ModSounds
import net.minecraft.client.player.LocalPlayer
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource


class ExtremeHatredFinalStageSound: AbstractTickableSoundInstance {
    private val player: LocalPlayer

    constructor(player: LocalPlayer) : super(ModSounds.EXTREME_HATRED_FINAL_STAGE_SOUND, SoundSource.PLAYERS, RandomSource.create()) {
        this.player = player
        looping = true
        delay = 0
        volume = 30F
        pitch = 1F
    }

    override fun tick() {
        if (!player.isAlive) {
            stop()
        }
    }
}