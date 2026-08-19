package love.marblegate.flowingagonyreborn.fx

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModSounds {
    val deferredRegister: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID)

    val miraculousEscapeHeartbeat: SoundEvent by deferredRegister.registerObject("miraculous_escape_heartbeat") {
        SoundEvent.createVariableRangeEvent(ResourceLocation(MODID, "miraculous_escape_heartbeat"))
    }

    val maliceOutbreakKnockbackSound: SoundEvent by deferredRegister.registerObject("malice_outbreak_knockback_sound") {
        SoundEvent.createVariableRangeEvent(ResourceLocation(MODID, "malice_outbreak_knockback_sound"))
    }

    val extremeHatredFirstStageSound: SoundEvent by deferredRegister.registerObject("extreme_hatred_first_stage_sound") {
        SoundEvent.createVariableRangeEvent(ResourceLocation(MODID, "extreme_hatred_first_stage_sound"))
    }

    val extremeHatredMediumStageSound: SoundEvent by deferredRegister.registerObject("extreme_hatred_medium_stage_sound") {
        SoundEvent.createVariableRangeEvent(ResourceLocation(MODID, "extreme_hatred_medium_stage_sound"))
    }

    val extremeHatredFinalStageSound: SoundEvent by deferredRegister.registerObject("extreme_hatred_final_stage_sound") {
        SoundEvent.createVariableRangeEvent(ResourceLocation(MODID, "extreme_hatred_final_stage_sound"))
    }
}