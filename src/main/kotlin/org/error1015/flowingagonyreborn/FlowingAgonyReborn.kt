package org.error1015.flowingagonyreborn

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import org.error1015.flowingagonyreborn.enchantment.ModEnchantments
import thedarkcolour.kotlinforforge.forge.*

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    init {
        runWhenOn(Dist.CLIENT) {
            ModEnchantments.Registry.register(MOD_BUS)
        }
        registerConfig(ModConfig.Type.SERVER, Config.actConfig)
    }
}