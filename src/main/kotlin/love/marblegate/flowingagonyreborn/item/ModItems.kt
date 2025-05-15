package love.marblegate.flowingagonyreborn.item

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItems {
    val MOD_ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    val LOGO by MOD_ITEMS.registerObject("logo") {
        Item(Item.Properties())
    }
}