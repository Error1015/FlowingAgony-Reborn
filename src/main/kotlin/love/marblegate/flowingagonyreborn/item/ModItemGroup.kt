package love.marblegate.flowingagonyreborn.item

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItemGroup {
    val registrar: DeferredRegister<CreativeModeTab> = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, ID)

    val modGroup: CreativeModeTab by registrar.register("flowingagony_reborn.group") { ->
        CreativeModeTab.builder().title(Component.translatable("itemGroup.flowingagony_reborn.group"))
            .icon { ModItems.flowingAgonyEnchantedBookItem.defaultInstance }.displayItems { _, output ->
                output.accept(ModItems.flowingAgonyEnchantedBookItem)
            }.build()
    }
}