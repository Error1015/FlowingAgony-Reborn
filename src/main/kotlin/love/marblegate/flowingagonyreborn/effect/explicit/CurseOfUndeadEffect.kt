package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

object CurseOfUndeadEffect : MobEffect(MobEffectCategory.HARMFUL, 0) {
    override fun getCurativeItems(): MutableList<ItemStack> {
        return mutableListOf(Items.ENCHANTED_GOLDEN_APPLE.defaultInstance)
    }
}