package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.ai.attributes.AttributeModifier

object PotentialBurstImplicitEffect : BeneficialBlankImplicitEffect() {
    override fun getAttributeModifierValue(
        pAmplifier: Int, pModifier: AttributeModifier
    ) = pModifier.amount * (1 + pAmplifier)
}