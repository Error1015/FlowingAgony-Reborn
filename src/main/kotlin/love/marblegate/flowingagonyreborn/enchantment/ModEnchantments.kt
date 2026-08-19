package love.marblegate.flowingagonyreborn.enchantment

import love.marblegate.flowingagonyreborn.MODID
import love.marblegate.flowingagonyreborn.enchantment.diceoffraud.*
import love.marblegate.flowingagonyreborn.enchantment.flameofenvy.*
import love.marblegate.flowingagonyreborn.enchantment.gloomyera.*
import love.marblegate.flowingagonyreborn.enchantment.innerpotential.*
import love.marblegate.flowingagonyreborn.enchantment.lastwish.GuidensRegretEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.LastSweetDreamEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.MorirsDeathwishEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.MorirsLifeboundEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lensofmalice.*
import love.marblegate.flowingagonyreborn.enchantment.madeofmadness.*
import love.marblegate.flowingagonyreborn.enchantment.madeofsuffering.*
import love.marblegate.flowingagonyreborn.enchantment.rootedinhatred.*
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.NecessaryEvilEnchantment
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.SurvivalRuseEnchantment
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.SurvivalShortcutEnchantment
import love.marblegate.flowingagonyreborn.enchantment.themistakens.*
import love.marblegate.flowingagonyreborn.enchantment.themistakens.curse.BurialObjectCurse
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.registerObject

object ModEnchantments {
    val deferredRegister: DeferredRegister<Enchantment> = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID)

    // Diceoffraud
    val anEnchantedGoldenAppleADay by deferredRegister.registerObject("an_enchanted_golden_apple_a_day") { AnEnchantedGoldenAppleADayEnchantment }
    val deathPunk by deferredRegister.registerObject("deathpunk") { DeathPunkEnchantment }
    val ExoticHealer by deferredRegister.registerObject("exotic_healer") { ExoticHealerEnchantment }
    val SavorTheTasted by deferredRegister.registerObject("savor_the_tasted") { SavorTheTastedEnchantment }
    val Trickster by deferredRegister.registerObject("trickster") { TricksterEnchantment }

    // flameofenvy
    val CovertKnife by deferredRegister.registerObject("covert_knife") { CovertKnifeEnchantment }
    val EnviousKind by deferredRegister.registerObject("envious_kind") { EnviousKindEnchantment }
    val Eyesore by deferredRegister.registerObject("eyesore") { EyesoreEnchantment }
    val SourceOfEnvy by deferredRegister.registerObject("source_of_envy") { SourceOfEnvyEnchantment }
    val ThornInFlesh by deferredRegister.registerObject("thorn_in_flesh") { ThornInFleshEnchantment }

    // gloomyera
    val CarefullyIdentified by deferredRegister.registerObject("carefully_identified") { CarefullyIdentifiedEnchantment }
    val CleansingBeforeUsing by deferredRegister.registerObject("cleansing_before_using") { CleansingBeforeUsingEnchantment }
    val ComeBackAtDusk by deferredRegister.registerObject("come_back_at_dusk") { ComeBackAtDuskEnchantment }
    val DirtyMoney by deferredRegister.registerObject("dirty_money") { DirtyMoneyEnchantment }
    val NimbleFinger by deferredRegister.registerObject("nimble_finger") { NimbleFingerEnchantment }
    val PilferageCreed by deferredRegister.registerObject("pilferage_creed") { PilferageCreedEnchantment }
    val RegularCustomerProgram by deferredRegister.registerObject("regular_customer_program") { RegularCustomerProgramEnchantment }

    // innerpotential
    val ArmorUp by deferredRegister.registerObject("armor_up") { ArmorUpEnchantment }
    val FrivolousStep by deferredRegister.registerObject("frivolous_step") { FrivolousStepEnchantment }
    val MiraculousEscape by deferredRegister.registerObject("miraculous_escape") { MiraculousEscapeEnchantment }
    val PotentialBurst by deferredRegister.registerObject("potential_burst") { PotentialBurstEnchantment }
    val StubbornStep by deferredRegister.registerObject("stubborn_step") { StubbornStepEnchantment }

    // lastwish
    val GuidensRegret by deferredRegister.registerObject("guidens_regret") { GuidensRegretEnchantment }
    val LastSweetDream by deferredRegister.registerObject("last_sweet_dream") { LastSweetDreamEnchantment }
    val MorirsDeathwish by deferredRegister.registerObject("morirs_deathwish") { MorirsDeathwishEnchantment }
    val MorirsLifebound by deferredRegister.registerObject("morirs_lifebound") { MorirsLifeboundEnchantment }

    // lensofmalice
    val BackAndFill by deferredRegister.registerObject("back_and_fill") { BackAndFillEnchantment }
    val InfectiousMalice by deferredRegister.registerObject("infectious_malice") { InfectiousMaliceEnchantment }
    val ISeeYouNow by deferredRegister.registerObject("i_see_you_now") { ISeeYouNowEnchantment }
    val MaliceOutbreak by deferredRegister.registerObject("malice_outbreak") { MaliceOutbreakEnchantment }
    val PerceivedMalice by deferredRegister.registerObject("perceived_malice") { PerceivedMaliceEnchantment }
    val Vengeance by deferredRegister.registerObject("vengeance") { VengeanceEnchantment }

    // madeofmadness
    val AgonyScreamer by deferredRegister.registerObject("agony_screamer") { AgonyScreamerEnchantment }
    val CuttingWatermelonDream by deferredRegister.registerObject("cutting_watermelon_dream") { CuttingWatermelonDreamEnchantment }
    val InsanePoet by deferredRegister.registerObject("insane_poet") { InsanePoetEnchantment }
    val PaperBrain by deferredRegister.registerObject("paper_brain") { PaperBrainEnchantment }
    val ShockTherapy by deferredRegister.registerObject("shock_therapy") { ShockTherapyEnchantment }

    // madeofsuffering
    val BurningPhobia by deferredRegister.registerObject("burning_phobia") { BurningPhobiaEnchantment }
    val ConstrainedHeart by deferredRegister.registerObject("constrained_heart") { ConstrainedHeartEnchantment }
    val DestructionWorship by deferredRegister.registerObject("destruction_worship") { DestructionWorshipEnchantment }
    val DrowningPhobia by deferredRegister.registerObject("drowning_phobia") { DrowningPhobiaEnchantment }
    val PiercingFever by deferredRegister.registerObject("piercing_fever") { PiercingFeverEnchantment }
    val PrayerOfPain by deferredRegister.registerObject("prayer_of_pain") { PrayerOfPainEnchantment }

    // rootedinhatred
    val FreshRevenge by deferredRegister.registerObject("fresh_revenge") { FreshRevengeEnchantment }
    val HatredBloodline by deferredRegister.registerObject("hatred_bloodline") { HatredBloodlineEnchantment }
    val OutrageoutSpirit by deferredRegister.registerObject("outrageous_spirit") { OutrageoutSpiritEnchantment }
    val ResentfulSou by deferredRegister.registerObject("resentful_soul") { ResentfulSoulEnchantment }
    val TooResentfulToDie by deferredRegister.registerObject("too_resentful_to_die") { TooResentfulToDieEnchantment }

    // survivaltricks
    val NecessaryEvil by deferredRegister.registerObject("necessary_evil") { NecessaryEvilEnchantment }
    val SurvivalShortcut by deferredRegister.registerObject("survival_shortcut") { SurvivalShortcutEnchantment }
    val SurvivalRuse by deferredRegister.registerObject("survival_ruse") { SurvivalRuseEnchantment }

    // themistakens
    val BurialObject by deferredRegister.registerObject("burial_object") { BurialObjectCurse }
    val CorruptedKindred by deferredRegister.registerObject("corrupted_kindred") { CorruptedKindredEnchantment }
    val LightburnFungalParasitic by deferredRegister.registerObject("lightburn_fungal_parasitic") { LightburnFungalParasiticEnchantment }
    val OriginalSinErosion by deferredRegister.registerObject("original_sin_erosion") { OriginalSinErosionEnchantment }
    val PrototypeChaotic by deferredRegister.registerObject("prototype_chaotic") { PrototypeChaoticEnchantment }
    val PrototypeChaoticTypeBeta by deferredRegister.registerObject("prototype_chaotic_type_beta") { PrototypeChaoticTypeBetaEnchantment }
    val ScholarOfOriginalSin by deferredRegister.registerObject("scholar_of_original_sin") { ScholarOfOriginalSinEnchantment }
    val Shadowborn by deferredRegister.registerObject("shadowborn") { ShadowbornEnchantment }
}