package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.item.ModItems
import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

const val ID = "flowingagony_reborn"

@Mod(ID)
object FlowingAgonyReborn {
    init {
        ModItems.registrar.register(MOD_BUS)
        ModItemGroup.registrar.register(MOD_BUS)

    }
}