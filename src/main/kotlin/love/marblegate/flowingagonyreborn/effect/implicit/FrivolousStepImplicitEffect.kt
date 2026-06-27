package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.ai.attributes.AttributeModifier

object FrivolousStepImplicitEffect : BeneficialBlankImplicitEffect() {
    override fun getAttributeModifierValue(
        pAmplifier: Int, pModifier: AttributeModifier
    ) = pModifier.amount + (0.15 * pAmplifier)
}