package org.error1015.flowingagonyreborn

import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.error1015.flowingagonyreborn.config.Config
import org.error1015.flowingagonyreborn.enchantment.ModEnchantments
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    private val LOGGER: Logger = LogManager.getLogger(MODID)

    init {
        runForDist({
            ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.actConfig)
            ModEnchantments.Registry.register(MOD_BUS)
        }) {}
    }
}