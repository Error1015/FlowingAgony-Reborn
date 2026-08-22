package love.marblegate.flowingagonyreborn.sound

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.util.asPath
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModSounds {
    val deferredRegister: DeferredRegister<SoundEvent> = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ID)

    val miraculousEscapeHeartbeat: SoundEvent by deferredRegister.register("miraculous_escape_heartbeat") { ->
        SoundEvent.createVariableRangeEvent("miraculous_escape_heartbeat".asPath)
    }

    val maliceOutbreakKnockbackSound: SoundEvent by deferredRegister.register("malice_outbreak_knockback_sound") { ->
        SoundEvent.createVariableRangeEvent("malice_outbreak_knockback_sound".asPath)
    }

    val extremeHatredFirstStageSound: SoundEvent by deferredRegister.register("extreme_hatred_first_stage_sound") { ->
        SoundEvent.createVariableRangeEvent("extreme_hatred_first_stage_sound".asPath)
    }

    val extremeHatredMediumStageSound: SoundEvent by deferredRegister.register("extreme_hatred_medium_stage_sound") { ->
        SoundEvent.createVariableRangeEvent("extreme_hatred_medium_stage_sound".asPath)
    }

    val extremeHatredFinalStageSound: SoundEvent by deferredRegister.register("extreme_hatred_final_stage_sound") { ->
        SoundEvent.createVariableRangeEvent("extreme_hatred_final_stage_sound".asPath)
    }
}