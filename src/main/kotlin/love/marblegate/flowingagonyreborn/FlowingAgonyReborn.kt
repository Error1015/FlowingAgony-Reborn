package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import thedarkcolour.kotlinforforge.forge.*

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    init {
        // 注册附魔
        runWhenOn(Dist.CLIENT) {
            ModEnchantments.Registry.register(MOD_BUS)
        }
        // 注册Config
        registerConfig(ModConfig.Type.SERVER, Config.spec)
    }
}