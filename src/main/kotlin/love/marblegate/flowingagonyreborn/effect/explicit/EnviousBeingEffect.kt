package love.marblegate.flowingagonyreborn.effect.explicit

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.ai.attributes.AttributeModifier

object EnviousBeingEffect : MobEffect(MobEffectCategory.BENEFICIAL, 0) {
    override fun getAttributeModifierValue(
        amplifier: Int,
        modifier: AttributeModifier
    ) = modifier.amount + amplifier
}