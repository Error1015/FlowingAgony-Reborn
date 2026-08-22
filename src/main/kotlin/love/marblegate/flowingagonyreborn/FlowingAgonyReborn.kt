package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.addition.CuriosApiAddition
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.item.ModItemGroup
import love.marblegate.flowingagonyreborn.item.ModItems
import love.marblegate.flowingagonyreborn.particle.ModParticleRegistrar
import love.marblegate.flowingagonyreborn.sound.ModSounds
import net.neoforged.fml.ModList
import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

const val ID = "flowingagony_reborn"

@Mod(ID)
object FlowingAgonyReborn {
    init {
        initRegistrar()
        // 联动
        loadCuriosApi()
    }


    fun initRegistrar() {
        ModItems.registrar.register(MOD_BUS)
        // ModEnchantmentComponents.enchantment_data_types.register(MOD_BUS)
        ModItemGroup.registrar.register(MOD_BUS)
        ModEffects.registrar.register(MOD_BUS)
        ModParticleRegistrar.registries.register(MOD_BUS)
        ModSounds.deferredRegister.register(MOD_BUS)
    }

    fun loadCuriosApi() {
        if (ModList.get().isLoaded("curios")) {
            CuriosApiAddition.load()
        }
    }
}