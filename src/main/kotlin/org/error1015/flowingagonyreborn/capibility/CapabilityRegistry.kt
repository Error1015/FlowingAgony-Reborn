package org.error1015.flowingagonyreborn.capibility

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.error1015.flowingagonyreborn.MODID

@Mod.EventBusSubscriber(modid = MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
object CapabilityRegistry {
    @SubscribeEvent
    fun registerCaps(event: RegisterCapabilitiesEvent) {
        event.register(AbnormalJoyCapability::class.java)
        event.register(CoolDown::class.java)
        event.register(HatredBloodlineStatusCapability::class.java)
        event.register(LastSweetDreamCapability::class.java)
    }
}