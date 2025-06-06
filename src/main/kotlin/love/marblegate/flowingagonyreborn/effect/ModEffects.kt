package love.marblegate.flowingagonyreborn.effect

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.effect.explicit.CursedAntipathyEffect
import love.marblegate.flowingagonyreborn.effect.explicit.CursedHatredEffect
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.effect.MobEffect
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModEffects {
    val registrar: DeferredRegister<MobEffect> = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ID)

    // Explicit
    val CURSED_HATRED: MobEffect by registrar.register("cursed_hatred") { -> CursedHatredEffect }
    val cursedAntipathy: MobEffect by registrar.register("cursed_antipathy") { -> CursedAntipathyEffect }
}