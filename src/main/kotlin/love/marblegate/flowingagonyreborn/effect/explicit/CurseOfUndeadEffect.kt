package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.neoforged.neoforge.common.EffectCure

object CurseOfUndeadEffect : MobEffect(MobEffectCategory.HARMFUL, 0) {
    override fun fillEffectCures(
        cures: MutableSet<EffectCure?>, effectInstance: MobEffectInstance
    ) {
        // 防止效果被牛奶等物品清空
        cures.add(EffectCure.get("enchanted_golden_apple"))
    }
}