package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.effect.ModEffects.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments.Enchantments
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import thedarkcolour.kotlinforforge.forge.*

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    init {
        Enchantments.register(MOD_BUS)
        ModEffects.register(MOD_BUS)
        registerConfig(ModConfig.Type.SERVER, Config.spec)
    }
}