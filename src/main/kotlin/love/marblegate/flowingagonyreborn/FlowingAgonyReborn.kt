package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.enchantment_effect_components.ModEnchantmentComponents
import love.marblegate.flowingagonyreborn.item.ModItems
import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

const val ID = "flowingagony_reborn"

@Mod(ID)
object FlowingAgonyReborn {
    init {
        ModItems.registrar.register(MOD_BUS)
        // ModEnchantmentComponents.enchantment_data_types.register(MOD_BUS)
        ModItemGroup.registrar.register(MOD_BUS)
    }
}