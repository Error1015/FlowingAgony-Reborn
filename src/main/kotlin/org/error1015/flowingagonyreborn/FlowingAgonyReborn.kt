package org.error1015.flowingagonyreborn

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.runForDist

const val MODID = "flowingagony_reborn"


@Mod(MODID)
object FlowingAgonyReborn {
    private val LOGGER: Logger = LogManager.getLogger(MODID)

    init {
       runForDist({

       }) {

       }
    }
}