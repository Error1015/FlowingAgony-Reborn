package love.marblegate.flowingagonyreborn.enchantment

import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.enchantment.diceoffraud.*
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.*
import love.marblegate.flowingagonyreborn.enchantment.gloomyera.*
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.*
import love.marblegate.flowingagonyreborn.enchantment.lastwish.*
import love.marblegate.flowingagonyreborn.enchantment.lensofmalice.*
import love.marblegate.flowingagonyreborn.enchantment.madeofmadness.*
import love.marblegate.flowingagonyreborn.enchantment.madeofsuffering.*
import love.marblegate.flowingagonyreborn.enchantment.rootedinhatred.*
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.*
import love.marblegate.flowingagonyreborn.enchantment.themistakens.*
import love.marblegate.flowingagonyreborn.enchantment.themistakens.curse.*
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModEnchantments {
    val Registry: DeferredRegister<Enchantment> = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID)

    // Diceoffraud
    val anEnchantedGoldenAppleADay by Registry.registerObject("an_enchanted_golden_apple_a_day") { AnEnchantedGoldenAppleADayEnchantment }
    val deathPunk by Registry.registerObject("deathpunk") { DeathPunkEnchantment }
    val ExoticHealer by Registry.registerObject("exotic_healer") { ExoticHealerEnchantment }
    val SavorTheTasted by Registry.registerObject("savor_the_tasted") { SavorTheTastedEnchantment }
    val Trickster by Registry.registerObject("trickster") { TricksterEnchantment }

    // flameofenvy
    val CovertKnife by Registry.registerObject("covert_knife") { CovertKnifeEnchantment }
    val EnviousKind by Registry.registerObject("envious_kind") { EnviousKindEnchantment }
    val Eyesore by Registry.registerObject("eyesore") { EyesoreEnchantment }
    val SourceOfEnvy by Registry.registerObject("source_of_envy") { SourceOfEnvyEnchantment }
    val ThornInFlesh by Registry.registerObject("thorn_in_flesh") { ThornInFleshEnchantment }

    // gloomyera
    val CarefullyIdentified by Registry.registerObject("carefully_identified") { CarefullyIdentifiedEnchantment }
    val CleansingBeforeUsing by Registry.registerObject("cleansing_before_using") { CleansingBeforeUsingEnchantment }
    val ComeBackAtDusk by Registry.registerObject("come_back_at_dusk") { ComeBackAtDuskEnchantment }
    val DirtyMoney by Registry.registerObject("dirty_money") { DirtyMoneyEnchantment }
    val NimbleFinger by Registry.registerObject("nimble_finger") { NimbleFingerEnchantment }
    val PilferageCreed by Registry.registerObject("pilferage_creed") { PilferageCreedEnchantment }
    val RegularCustomerProgram by Registry.registerObject("regular_customer_program") { RegularCustomerProgramEnchantment }

    // innerpotential
    val ArmorUp by Registry.registerObject("armor_up") { ArmorUpEnchantment }
    val FrivolousStep by Registry.registerObject("frivolous_step") { FrivolousStepEnchantment }
    val MiraculousEscape by Registry.registerObject("miraculous_escape") { MiraculousEscapeEnchantment }
    val PotentialBurst by Registry.registerObject("potential_burst") { PotentialBurstEnchantment }
    val StubbornStep by Registry.registerObject("stubborn_step") { StubbornStepEnchantment }

    // lastwish
    val GuidensRegret by Registry.registerObject("guidens_regret") { GuidensRegretEnchantment }
    val LastSweetDream by Registry.registerObject("last_sweet_dream") { LastSweetDreamEnchantment }
    val MorirsDeathwish by Registry.registerObject("morirs_deathwish") { MorirsDeathwishEnchantment }
    val MorirsLifebound by Registry.registerObject("morirs_lifebound") { MorirsLifeboundEnchantment }

    // lensofmalice
    val BackAndFill by Registry.registerObject("back_and_fill") { BackAndFillEnchantment }
    val InfectiousMalice by Registry.registerObject("infectious_malice") { InfectiousMaliceEnchantment }
    val ISeeYouNow by Registry.registerObject("i_see_you_now") { ISeeYouNowEnchantment }
    val MaliceOutbreak by Registry.registerObject("malice_outbreak") { MaliceOutbreakEnchantment }
    val PerceivedMalice by Registry.registerObject("perceived_malice") { PerceivedMaliceEnchantment }
    val Vengeance by Registry.registerObject("vengeance") { VengeanceEnchantment }

    // madeofmadness
    val AgonyScreamer by Registry.registerObject("agony_screamer") { AgonyScreamerEnchantment }
    val CuttingWatermelonDream by Registry.registerObject("cutting_watermelon_dream") { CuttingWatermelonDreamEnchantment }
    val InsanePoet by Registry.registerObject("insane_poet") { InsanePoetEnchantment }
    val PaperBrain by Registry.registerObject("paper_brain") { PaperBrainEnchantment }
    val ShockTherapy by Registry.registerObject("shock_therapy") { ShockTherapyEnchantment }

    // madeofsuffering
    val BurningPhobia by Registry.registerObject("burning_phobia") { BurningPhobiaEnchantment }
    val ConstrainedHeart by Registry.registerObject("constrained_heart") { ConstrainedHeartEnchantment }
    val DestructionWorship by Registry.registerObject("destruction_worship") { DestructionWorshipEnchantment }
    val DrowningPhobia by Registry.registerObject("drowning_phobia") { DrowningPhobiaEnchantment }
    val PiercingFever by Registry.registerObject("piercing_fever") { PiercingFeverEnchantment }
    val PrayerOfPain by Registry.registerObject("prayer_of_pain") { PrayerOfPainEnchantment }

    // rootedinhatred
    val FreshRevenge by Registry.registerObject("fresh_revenge") { FreshRevengeEnchantment }
    val HatredBloodline by Registry.registerObject("hatred_bloodline") { HatredBloodlineEnchantment }
    val OutrageoutSpirit by Registry.registerObject("outrageous_spirit") { OutrageoutSpiritEnchantment }
    val ResentfulSou by Registry.registerObject("resentful_soul") { ResentfulSoulEnchantment }
    val TooResentfulToDie by Registry.registerObject("too_resentful_to_die") { TooResentfulToDieEnchantment }

    // survivaltricks
    val NecessaryEvil by Registry.registerObject("necessary_evil") { NecessaryEvilEnchantment }
    val SurvivalShortcut by Registry.registerObject("survival_shortcut") { SurvivalShortcutEnchantment }
    val SurvivalRuse by Registry.registerObject("survival_ruse") { SurvivalRuseEnchantment }

    // themistakens
    val BurialObject by Registry.registerObject("burial_object") { BurialObjectCurse }
    val CorruptedKindred by Registry.registerObject("corrupted_kindred") { CorruptedKindredEnchantment }
    val LightburnFungalParasitic by Registry.registerObject("lightburn_fungal_parasitic") { LightburnFungalParasiticEnchantment }
    val OriginalSinErosion by Registry.registerObject("original_sin_erosion") { OriginalSinErosionEnchantment }
    val PrototypeChaotic by Registry.registerObject("prototype_chaotic") { PrototypeChaoticEnchantment }
    val PrototypeChaoticTypeBeta by Registry.registerObject("prototype_chaotic_type_beta") { PrototypeChaoticTypeBetaEnchantment }
    val ScholarOfOriginalSin by Registry.registerObject("scholar_of_original_sin") { ScholarOfOriginalSinEnchantment }
    val Shadowborn by Registry.registerObject("shadowborn") { ShadowbornEnchantment }
}