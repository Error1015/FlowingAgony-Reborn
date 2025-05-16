package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.ModItemGroup.GroupRegistries
import love.marblegate.flowingagonyreborn.effect.ModEffects.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments.Enchantments
import love.marblegate.flowingagonyreborn.fx.ModParticle.ParticleTypes
import love.marblegate.flowingagonyreborn.fx.ModSounds.Sounds
import love.marblegate.flowingagonyreborn.item.ModItems.MOD_ITEMS
import love.marblegate.flowingagonyreborn.network.Networking
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerConfig

const val MODID = "flowingagony_reborn"

@Mod(MODID)
object FlowingAgonyReborn {
    init {
        Enchantments.register(MOD_BUS)
        ModEffects.register(MOD_BUS)
        MOD_ITEMS.register(MOD_BUS)
        ParticleTypes.register(MOD_BUS)
        Sounds.register(MOD_BUS)
        registerConfig(ModConfig.Type.COMMON, Config.spec)
        GroupRegistries.register(MOD_BUS)
        Networking // 初始化Networking
    }
}