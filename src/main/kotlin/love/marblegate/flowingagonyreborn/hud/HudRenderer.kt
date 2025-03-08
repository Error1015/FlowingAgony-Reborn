package love.marblegate.flowingagonyreborn.hud

import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(value = [Dist.CLIENT])
object HudRenderer {
    @SubscribeEvent
    fun onOverlayRender(event: RenderGuiOverlayEvent.Post) {
        if (Minecraft.getInstance().player == null) return
        val abnormalJoyHUD = AbnormalJoyHUD(event.poseStack)
        abnormalJoyHUD.render()
    }
}