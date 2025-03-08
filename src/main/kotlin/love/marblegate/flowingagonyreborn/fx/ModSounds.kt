package love.marblegate.flowingagonyreborn.fx

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModSounds {
    val Sounds: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID)

    val MIRACULOUS_ESCAPE_HEARTBEAT: SoundEvent by Sounds.registerObject("miraculous_escape_heartbeat") {
        SoundEvent(ResourceLocation(MODID, "miraculous_escape_heartbeat"))
    }

    val MALICE_OUTBREAK_KNOCKBACK_SOUND: SoundEvent by Sounds.registerObject("malice_outbreak_knockback_sound") {
        SoundEvent(ResourceLocation(MODID, "malice_outbreak_knockback_sound"))
    }

    val EXTREME_HATRED_FIRST_STAGE_SOUND: SoundEvent by Sounds.registerObject("extreme_hatred_first_stage_sound") {
        SoundEvent(ResourceLocation(MODID, "extreme_hatred_first_stage_sound"))
    }

    val EXTREME_HATRED_MEDIUM_STAGE_SOUND: SoundEvent by Sounds.registerObject("extreme_hatred_medium_stage_sound") {
        SoundEvent(ResourceLocation(MODID, "extreme_hatred_medium_stage_sound"))
    }

    val EXTREME_HATRED_FINAL_STAGE_SOUND: SoundEvent by Sounds.registerObject("extreme_hatred_final_stage_sound") {
        SoundEvent(ResourceLocation(MODID, "extreme_hatred_final_stage_sound"))
    }

}