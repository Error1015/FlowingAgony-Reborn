package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.ai.attributes.AttributeModifier

object BackAndFillImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun getAttributeModifierValue(
        amplifier: Int, modifier: AttributeModifier
    ): Double {
        return modifier.amount * (amplifier + 1).toDouble()
    }
}