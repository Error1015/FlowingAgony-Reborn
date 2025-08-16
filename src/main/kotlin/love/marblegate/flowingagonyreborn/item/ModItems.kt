package love.marblegate.flowingagonyreborn.item

import love.marblegate.flowingagonyreborn.MODID
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModItems {
    val MOD_ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    val FLOWING_AGONY_ENCHANTED_BOOK: Item by MOD_ITEMS.registerObject("flowing_agony_enchanted_book") {
        FlowingAgonyEnchantedBookItem(
            Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
        )
    }
}