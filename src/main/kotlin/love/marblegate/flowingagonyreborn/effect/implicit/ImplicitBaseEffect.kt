package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.client.gui.Gui
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.item.ItemStack
import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions
import java.util.function.Consumer

open class ImplicitBaseEffect(typeIn: MobEffectCategory = MobEffectCategory.NEUTRAL) : MobEffect(typeIn, 0) {

    override fun getCurativeItems(): List<ItemStack> = arrayListOf()

    override fun initializeClient(consumer: Consumer<IClientMobEffectExtensions>) {
        consumer.accept(object : IClientMobEffectExtensions {
            override fun isVisibleInGui(instance: MobEffectInstance?) = false

            override fun isVisibleInInventory(instance: MobEffectInstance?) = false

            override fun renderInventoryIcon(
                instance: MobEffectInstance?, screen: EffectRenderingInventoryScreen<*>?, guiGraphics: GuiGraphics?, x: Int, y: Int, blitOffset: Int
            ) = false

            override fun renderInventoryText(
                instance: MobEffectInstance?, screen: EffectRenderingInventoryScreen<*>?, guiGraphics: GuiGraphics?, x: Int, y: Int, blitOffset: Int
            ) = false

            override fun renderGuiIcon(
                instance: MobEffectInstance?, gui: Gui?, guiGraphics: GuiGraphics?, x: Int, y: Int, z: Float, alpha: Float
            ) = false
        })
    }
}