package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.capibility.CoolDown
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber
object CoolDownHandler {
    @SubscribeEvent
    fun handle(event: TickEvent.PlayerTickEvent) {
        if (event.player.level.isClientSide) return
        if (event.phase == TickEvent.Phase.START) {
            val coolDownCap = event.player.getCapability(ModCapManager.CoolDown_Capability)
            coolDownCap.ifPresent { cap ->
                for (coolDownType in CoolDown.CoolDownType.entries) {
                    if (!cap.isReady(coolDownType)) {
                        cap.decrease(coolDownType)
                    }
                }
            }
        }
    }
}