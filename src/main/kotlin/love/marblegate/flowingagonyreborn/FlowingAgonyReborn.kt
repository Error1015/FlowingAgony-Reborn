package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.ModItemGroup.GroupRegistries
import love.marblegate.flowingagonyreborn.effect.ModEffects.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments.Enchantments
import love.marblegate.flowingagonyreborn.fx.ModParticle.ParticleTypes
import love.marblegate.flowingagonyreborn.fx.ModSounds.Sounds
import love.marblegate.flowingagonyreborn.item.ModItems.ItemRegistries
import love.marblegate.flowingagonyreborn.network.Networking
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.registerConfig
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

const val MODID = "flowingagony_reborn"

@Mod(MODID)
@Mod.EventBusSubscriber
object FlowingAgonyReborn {
    init {
        Enchantments.register(MOD_BUS)
        ModEffects.register(MOD_BUS)
        ItemRegistries.register(MOD_BUS)
        ParticleTypes.register(MOD_BUS)
        Sounds.register(MOD_BUS)
        registerConfig(ModConfig.Type.COMMON, Config.spec)
        GroupRegistries.register(MOD_BUS)

        // 游戏初始化的时候初始化Networking
        MOD_BUS.addListener { _: FMLCommonSetupEvent ->
            Networking.registerMessage()
        }
    }
}