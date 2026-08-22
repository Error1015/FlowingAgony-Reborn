package love.marblegate.flowingagonyreborn.effect

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.effect.explicit.CurseOfUndeadEffect
import love.marblegate.flowingagonyreborn.effect.explicit.CursedAntipathyEffect
import love.marblegate.flowingagonyreborn.effect.explicit.CursedHatredEffect
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.effect.MobEffect
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister


object ModEffects {
    val registrar: DeferredRegister<MobEffect> = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ID)

    // Explicit
    val cursedHatred: DeferredHolder<MobEffect, CursedHatredEffect> = registrar.register("cursed_hatred") { -> CursedHatredEffect }
    val cursedAntipathy: DeferredHolder<MobEffect, CursedAntipathyEffect> = registrar.register("cursed_antipathy") { -> CursedAntipathyEffect }
    val curseOfUndeadEffect: DeferredHolder<MobEffect, CurseOfUndeadEffect> = registrar.register("curse_of_undead") { -> CurseOfUndeadEffect }
}