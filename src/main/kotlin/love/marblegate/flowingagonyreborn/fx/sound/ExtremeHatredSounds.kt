package love.marblegate.flowingagonyreborn.fx.sound

import love.marblegate.flowingagonyreborn.fx.ModSounds
import net.minecraft.client.player.LocalPlayer
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource


open class ExtremeHatredSoundBasic(val player: LocalPlayer, stage: ExtremeHatredSoundStage) : AbstractTickableSoundInstance(
    matchStage(stage), SoundSource.PLAYERS, RandomSource.create()
) {
    override fun tick() {
        if (!player.isAlive) {
            stop()
        }
    }
}

class ExtremeHatredFirstStageSound(player: LocalPlayer) : ExtremeHatredSoundBasic(player, ExtremeHatredSoundStage.Start) {
    init {
        looping = true
        delay = 0
        volume = 35F
        pitch = 1F
    }
}

class ExtremeHatredMediumStageSound(player: LocalPlayer) : ExtremeHatredSoundBasic(player, ExtremeHatredSoundStage.Medium) {
    init {
        looping = true
        delay = 0
        volume = 35F
        pitch = 1F
    }
}

class ExtremeHatredFinalStageSound(player: LocalPlayer) : ExtremeHatredSoundBasic(player, ExtremeHatredSoundStage.End) {
    init {
        looping = true
        delay = 0
        volume = 30F
        pitch = 1F
    }
}

enum class ExtremeHatredSoundStage {
    Start,
    Medium,
    End
}

fun matchStage(stage: ExtremeHatredSoundStage): SoundEvent = when (stage) {
    ExtremeHatredSoundStage.Start -> ModSounds.extremeHatredFirstStageSound
    ExtremeHatredSoundStage.Medium -> ModSounds.extremeHatredMediumStageSound
    ExtremeHatredSoundStage.End -> ModSounds.extremeHatredFinalStageSound
}