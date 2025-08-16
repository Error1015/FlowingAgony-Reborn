package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.ai.attributes.AttributeModifier

object FreshRevengeImplicitEffect : BeneficialBlankImplicitEffect() {
    override fun getAttributeModifierValue(
        pAmplifier: Int, pModifier: AttributeModifier
    ) = pModifier.amount + pAmplifier + 1
}