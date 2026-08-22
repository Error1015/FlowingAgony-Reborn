package love.marblegate.flowingagonyreborn.item

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val registrar: DeferredRegister.Items = DeferredRegister.createItems(ID)

    val flowingAgonyEnchantedBookItem: Item by registrar.register("flowing_agony_enchanted_book") { ->
        FlowingAgonyEnchantedBookItem(
            Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
        )
    }
}