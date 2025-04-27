package love.marblegate.flowingagonyreborn.item

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItems {
    val ItemRegistries: DeferredRegister<Item> = DeferredRegister.create(Registries.ITEM, MODID)

    val Logo by ItemRegistries.registerObject("logo") { Item(Properties().stacksTo(1)) }
}