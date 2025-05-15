package love.marblegate.flowingagonyreborn.hud

import com.mojang.blaze3d.systems.RenderSystem
import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.capibility.AbnormalJoyCapability
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.common.util.LazyOptional

class AbnormalJoyHUD {
    private val minecraft: Minecraft = Minecraft.getInstance()
    private val hud = ResourceLocation(MODID, "textures/gui/flowing_agony_hud_1.png")

    fun render(guiGraphics: GuiGraphics) {
        if (!minecraft.options.hideGui && minecraft.gameMode?.hasExperience() == true) {
            val player = minecraft.player ?: return
            val cap: LazyOptional<AbnormalJoyCapability> = player.getCapability(ModCapManager.AbnormalJoy_Capability)

            cap.ifPresent { capability ->
                val abnormalJoyPoint = capability
                    .getPoint()
                    .toInt()
                if (abnormalJoyPoint != 0) {
                    RenderSystem.setShaderTexture(0, hud)
                    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)

                    val width = minecraft.window.guiScaledWidth
                    val height = minecraft.window.guiScaledHeight
                    val x = width / 2 - 91
                    val y = height - 32 + 3 + 3

                    // 绘制背景
                    guiGraphics.blit(hud, x, y, 0f, 0f, 182, 3, 182, 6)

                    // 绘制填充条
                    val progress = (abnormalJoyPoint / 100f * 182).toInt()
                    guiGraphics.blit(hud, x, y, 0f, 3f, progress, 3, 182, 6)
                }
            }
        }
    }
}