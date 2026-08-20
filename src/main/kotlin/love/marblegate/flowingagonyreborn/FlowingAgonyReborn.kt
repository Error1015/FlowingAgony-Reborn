package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.config.EnchantmentConfig
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments
import love.marblegate.flowingagonyreborn.fx.ModParticle
import love.marblegate.flowingagonyreborn.fx.ModSounds
import love.marblegate.flowingagonyreborn.item.ModItemGroup
import love.marblegate.flowingagonyreborn.item.ModItems
import love.marblegate.flowingagonyreborn.network.Networking
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerConfig

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    init {
        ModEnchantments.deferredRegister.register(MOD_BUS)
        ModEffects.deferredRegister.register(MOD_BUS)
        ModItems.deferredRegister.register(MOD_BUS)
        ModParticle.deferredRegister.register(MOD_BUS)
        ModSounds.deferredRegister.register(MOD_BUS)
        // Config Register
        registerConfig(ModConfig.Type.COMMON, CommonConfig.spec, "$MODID/$MODID-common.toml")
        registerConfig(ModConfig.Type.COMMON, EnchantmentConfig.spec, "$MODID/$MODID-enchantments_settings.toml")
        ModItemGroup.deferredRegister.register(MOD_BUS)
        Networking // 初始化Networking
    }
}