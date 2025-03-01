package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.network.Networking
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

@Mod.EventBusSubscriber
object CommonEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        event.enqueueWork(Networking::registerMessage)
    }
}