package love.marblegate.flowingagonyreborn.enchantment_effect_components

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.core.registries.BuiltInRegistries
import net.neoforged.neoforge.registries.DeferredRegister

object ModEnchantmentComponents {
    val enchantmentDataTypes = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, ID)


}