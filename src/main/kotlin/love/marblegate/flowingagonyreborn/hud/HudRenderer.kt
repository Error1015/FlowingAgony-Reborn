package love.marblegate.flowingagonyreborn.hud

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay

@Mod.EventBusSubscriber(value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.MOD)
object HudRenderer {
    private val ABNORMAL_JOY_HUD = AbnormalJoyHUD()

    @SubscribeEvent
    fun onOverlayRender(event: RegisterGuiOverlaysEvent) {
        event.registerAbove(VanillaGuiOverlay.HOTBAR.id(), "abnormal_joy_hud") { _, guiGraphics, _, _, _ ->
            ABNORMAL_JOY_HUD.render(guiGraphics)
        }
    }
}