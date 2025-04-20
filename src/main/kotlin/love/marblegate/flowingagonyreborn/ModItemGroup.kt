package love.marblegate.flowingagonyreborn

import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments
import love.marblegate.flowingagonyreborn.item.ModItems
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.EnchantedBookItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.EnchantmentInstance
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject
import net.minecraft.world.item.CreativeModeTab as ItemGroup

object ModItemGroup {
    val GroupRegistries: DeferredRegister<ItemGroup> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

    val EnchantedBookItems: Collection<ItemStack>
        get() = ModEnchantments.Enchantments.entries.map { obj ->
            EnchantedBookItem.createForEnchantment(
                EnchantmentInstance(
                    obj.get(),
                    obj.get().maxLevel
                )
            )
        }

    val EnchantmentsGroup: ItemGroup by GroupRegistries.registerObject("flowingagony_reborn.group") {
        ItemGroup
            .builder()
            .title(Component.translatable("itemGroup.flowingagony_reborn.group"))
            .icon { ModItems.Logo.defaultInstance }
            .displayItems { _, output -> output.acceptAll(EnchantedBookItems) }
            .build()
    }
}