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

    val EnchantmentsGroup: ItemGroup by GroupRegistries.registerObject("flowingagony_reborn.group") {
        ItemGroup
            .builder()
            .title(Component.translatable("itemGroup.flowingagony_reborn.group"))
            .icon { ModItems.Logo.defaultInstance }
            .displayItems { _, output ->
                enchantedBookItems.forEach { output.accept(it) }
            }
            .build()
    }

    private fun getEnchantedBookStacks(): List<ItemStack> {
        val stacks = mutableListOf<ItemStack>()
        var enchantment: Enchantment
        ModEnchantments.Enchantments.entries.forEach {
            enchantment = it?.get() ?: return
            val enchantedBook = EnchantedBookItem.createForEnchantment(EnchantmentInstance(enchantment, enchantment.maxLevel)) ?: return
            stacks += enchantedBook
        }
        return stacks
    }

    private val enchantedBookItems: List<ItemStack> get() = getEnchantedBookStacks()
}