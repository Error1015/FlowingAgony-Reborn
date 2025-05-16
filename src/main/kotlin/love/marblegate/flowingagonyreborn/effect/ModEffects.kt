package love.marblegate.flowingagonyreborn.effect

import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.effect.explicit.*
import love.marblegate.flowingagonyreborn.effect.implicit.*
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModEffects {
    val ModEffects: DeferredRegister<MobEffect> = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID)

    // Explicit
    val CURSED_HATRED by ModEffects.registerObject("cursed_hatred") { CursedHatredEffect }
    val CURSED_ANTIPATHY by ModEffects.registerObject("cursed_antipathy") { CursedAntipathyEffect }
    val EXTREME_HATRED by ModEffects.registerObject("extreme_hatred") { ExtremeHatredEffect }
    val AGONY_RESONANCE by ModEffects.registerObject("agony_resonance") { SimpleEffect(MobEffectCategory.NEUTRAL, 57344) }
    val BEEN_RESONATED by ModEffects.registerObject("been_resonated") { SimpleEffect(MobEffectCategory.NEUTRAL, 57344) }
    val CURSE_OF_UNDEAD by ModEffects.registerObject("curse_of_undead") { CurseOfUndeadEffect }
    val LET_ME_SAVOR_IT by ModEffects.registerObject("let_me_savor_it") { SimpleEffect(MobEffectCategory.BENEFICIAL, 11420160) }
    val LISTEN_TO_ME_SINGING by ModEffects.registerObject("listen_to_me_singing") { ListenToMeSingingEffect }
    val LIGHTBURN_FUNGAL_INFECTION by ModEffects.registerObject("lightburn_fungal_infection") { LightburnFungalInfectionEffect }
    val ENVIOUS_BEING: MobEffect by ModEffects.registerObject("envious_being") {
        EnviousBeingEffect.addAttributeModifier(Attributes.ATTACK_DAMAGE, "444E310D-DE08-4D8D-A4B1-33B06CFB8703", 4.0, AttributeModifier.Operation.ADDITION)
    }

    // Implicit
    val BACK_AND_FILL_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("back_and_fill_enchantment_active") {
        BackAndFillImplicitEffect.addAttributeModifier(Attributes.MOVEMENT_SPEED, "D6984A53-7DD1-4093-9878-345958E2E92A", -0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)
    }
    val POTENTIAL_BURST_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("potential_burst_enchantment_active") {
        PotentialBurstImplicitEffect.addAttributeModifier(Attributes.MOVEMENT_SPEED, "B22509E7-3596-430F-8F88-66A3EAFC99F7", 0.01, AttributeModifier.Operation.MULTIPLY_BASE)
    }
    val FRIVOLOUS_STEP_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("frivolous_step_enchantment_active") {
        FrivolousStepImplicitEffect.addAttributeModifier(Attributes.MOVEMENT_SPEED, "412C831F-22EA-43B8-B74B-D172019AD3D2", 0.15, AttributeModifier.Operation.MULTIPLY_BASE)
    }
    val HATRED_BLOODLINE_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("hatred_bloodline_enchantment_active") {
        HatredBloodlineImplicitEffect
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "C164A28C-4A60-4957-B414-1DF28bb56C74", 0.0083, AttributeModifier.Operation.ADDITION)
            .addAttributeModifier(Attributes.ATTACK_SPEED, "F07D977E-F516-4D16-9088-11B70D847FFA", 0.33, AttributeModifier.Operation.ADDITION)
    }
    val FRESH_REVENGE_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("fresh_revenge_enchantment_active") {
        FreshRevengeImplicitEffect.addAttributeModifier(Attributes.ATTACK_DAMAGE, "f07d977e-f516-4d16-9088-11b70d847ffa", 2.0, AttributeModifier.Operation.ADDITION)
    }
    val PROTOTYPE_CHAOTIC_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("prototype_chaotic_enchantment_active") {
        PrototypeChaoticImplicitEffect.addAttributeModifier(Attributes.MAX_HEALTH, "54405E8E-078E-46B0-9231-4B124C2964E6", 1.0, AttributeModifier.Operation.ADDITION)
    }
    val INSANE_POET_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("insane_poet_enchantment_active") {
        HarmfulBlankImplicitEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, "4A2B62AC-37EC-4A06-94FF-ED6E2B2870B6", -0.8, AttributeModifier.Operation.MULTIPLY_BASE)
    }
    val MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE by ModEffects.registerObject("miraculous_escape_enchantment_active") { BeneficialBlankImplicitEffect() }
    val MIRACULOUS_ESCAPE_ENCHANTMENT_FORCE_ESCAPE by ModEffects.registerObject("miraculous_escape_enchantment_force_escape") { MiraculousEscapeForceEscapeEffect }
    val PAPER_BRAIN_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("paper_brain_enchantment_active") {
        PaperBrainImplicitEffect
            .addAttributeModifier(Attributes.FOLLOW_RANGE, "831CF4BC-ED83-4072-A2A2-C115DD72317F", -0.96, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "6E21DF28-A639-43E5-A189-D9ECFAE3AA39", -0.67, AttributeModifier.Operation.MULTIPLY_TOTAL)
    }
    val SHOCK_THERAPY_ENCHANTMENT_ACTIVE: MobEffect by ModEffects.registerObject("shock_therapy_enchantment_active") {
        ShockTherapyImplicitEffect
            .addAttributeModifier(Attributes.FOLLOW_RANGE, "BA46BF78-B706-4FB0-9EA0-98978BB648B1", -0.96, AttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "058D9210-1B26-4578-85C9-2CF67698F1E1", -0.67, AttributeModifier.Operation.MULTIPLY_TOTAL)
    }
    val THORN_IN_FLESH_ACTIVE: MobEffect by ModEffects.registerObject("thorn_in_flesh_active") {
        ThornInFleshImplicitEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, "081F9BE2-F716-49B4-A579-62582F2A9DA8", -0.5, AttributeModifier.Operation.MULTIPLY_TOTAL)
    }
    val THORN_IN_FLESH_ACTIVE_FOR_PLAYER: MobEffect by ModEffects.registerObject("thorn_in_flesh_active_for_player") {
        ThornInFleshImplicitEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, "228345E7-66DC-4808-B325-82BE7728D3FC", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)
    }
    val EYESORE_ENCHANTMENT_ACTIVE by ModEffects.registerObject("eyesore_enchantment_active") { EyesoreImplicitEffect }
}