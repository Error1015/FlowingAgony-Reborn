package love.marblegate.flowingagonyreborn.capibility

import love.marblegate.flowingagonyreborn.MODID
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object CapabilityRegistry {
    @SubscribeEvent
    fun registerCaps(event: RegisterCapabilitiesEvent) {
        event.register(AbnormalJoyCapability::class.java)
        event.register(CoolDown::class.java)
        event.register(HatredBloodlineStatusCapability::class.java)
        event.register(LastSweetDreamCapability::class.java)
    }
}