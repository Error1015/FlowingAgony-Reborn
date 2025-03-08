package love.marblegate.flowingagonyreborn.hud

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.PoseStack
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiComponent
import net.minecraft.resources.ResourceLocation
import kotlin.math.floor

class AbnormalJoyHUD(private val matrixStack: PoseStack) : GuiComponent() {
    private val width = Minecraft.getInstance().window.guiScaledWidth
    private val height = Minecraft.getInstance().window.guiScaledHeight
    private val minecraft = Minecraft.getInstance()
    private val HUD = ResourceLocation("flowingagony", "textures/gui/flowing_agony_hud_1.png")

    fun render() {
        if (!minecraft.options.hideGui && minecraft.gameMode?.hasExperience() == true) {
            var abnormalJoyPoint = 0
            val pointCap = minecraft.player?.getCapability(ModCapManager.AbnormalJoy_Capability)
            pointCap?.ifPresent { cap ->
                abnormalJoyPoint = floor(cap.getPoint().toDouble()).toInt()
            }

            if (abnormalJoyPoint != 0) {
                RenderSystem.setShaderTexture(0, HUD)
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)

                val x = width / 2 - 91
                val y = height - 32 + 3 + 3
                // Render Background
                blit(matrixStack, x, y, 0, 0, 182, 3)

                val k = (abnormalJoyPoint / 100f * 182.0f).toInt()
                // Render Filler
                blit(matrixStack, x, y, 0, 3, k, 3)
            }
        }
    }
}