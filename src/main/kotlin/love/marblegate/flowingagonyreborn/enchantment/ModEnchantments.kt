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
    val Enchantments: DeferredRegister<Enchantment> = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID)

    // Diceoffraud
    val anEnchantedGoldenAppleADay by Enchantments.registerObject("an_enchanted_golden_apple_a_day") { AnEnchantedGoldenAppleADayEnchantment }
    val deathPunk by Enchantments.registerObject("deathpunk") { DeathPunkEnchantment }
    val ExoticHealer by Enchantments.registerObject("exotic_healer") { ExoticHealerEnchantment }
    val SavorTheTasted by Enchantments.registerObject("savor_the_tasted") { SavorTheTastedEnchantment }
    val Trickster by Enchantments.registerObject("trickster") { TricksterEnchantment }

    // flameofenvy
    val CovertKnife by Enchantments.registerObject("covert_knife") { CovertKnifeEnchantment }
    val EnviousKind by Enchantments.registerObject("envious_kind") { EnviousKindEnchantment }
    val Eyesore by Enchantments.registerObject("eyesore") { EyesoreEnchantment }
    val SourceOfEnvy by Enchantments.registerObject("source_of_envy") { SourceOfEnvyEnchantment }
    val ThornInFlesh by Enchantments.registerObject("thorn_in_flesh") { ThornInFleshEnchantment }

    // gloomyera
    val CarefullyIdentified by Enchantments.registerObject("carefully_identified") { CarefullyIdentifiedEnchantment }
    val CleansingBeforeUsing by Enchantments.registerObject("cleansing_before_using") { CleansingBeforeUsingEnchantment }
    val ComeBackAtDusk by Enchantments.registerObject("come_back_at_dusk") { ComeBackAtDuskEnchantment }
    val DirtyMoney by Enchantments.registerObject("dirty_money") { DirtyMoneyEnchantment }
    val NimbleFinger by Enchantments.registerObject("nimble_finger") { NimbleFingerEnchantment }
    val PilferageCreed by Enchantments.registerObject("pilferage_creed") { PilferageCreedEnchantment }
    val RegularCustomerProgram by Enchantments.registerObject("regular_customer_program") { RegularCustomerProgramEnchantment }

    // innerpotential
    val ArmorUp by Enchantments.registerObject("armor_up") { ArmorUpEnchantment }
    val FrivolousStep by Enchantments.registerObject("frivolous_step") { FrivolousStepEnchantment }
    val MiraculousEscape by Enchantments.registerObject("miraculous_escape") { MiraculousEscapeEnchantment }
    val PotentialBurst by Enchantments.registerObject("potential_burst") { PotentialBurstEnchantment }
    val StubbornStep by Enchantments.registerObject("stubborn_step") { StubbornStepEnchantment }

    // lastwish
    val GuidensRegret by Enchantments.registerObject("guidens_regret") { GuidensRegretEnchantment }
    val LastSweetDream by Enchantments.registerObject("last_sweet_dream") { LastSweetDreamEnchantment }
    val MorirsDeathwish by Enchantments.registerObject("morirs_deathwish") { MorirsDeathwishEnchantment }
    val MorirsLifebound by Enchantments.registerObject("morirs_lifebound") { MorirsLifeboundEnchantment }

    // lensofmalice
    val BackAndFill by Enchantments.registerObject("back_and_fill") { BackAndFillEnchantment }
    val InfectiousMalice by Enchantments.registerObject("infectious_malice") { InfectiousMaliceEnchantment }
    val ISeeYouNow by Enchantments.registerObject("i_see_you_now") { ISeeYouNowEnchantment }
    val MaliceOutbreak by Enchantments.registerObject("malice_outbreak") { MaliceOutbreakEnchantment }
    val PerceivedMalice by Enchantments.registerObject("perceived_malice") { PerceivedMaliceEnchantment }
    val Vengeance by Enchantments.registerObject("vengeance") { VengeanceEnchantment }

    // madeofmadness
    val AgonyScreamer by Enchantments.registerObject("agony_screamer") { AgonyScreamerEnchantment }
    val CuttingWatermelonDream by Enchantments.registerObject("cutting_watermelon_dream") { CuttingWatermelonDreamEnchantment }
    val InsanePoet by Enchantments.registerObject("insane_poet") { InsanePoetEnchantment }
    val PaperBrain by Enchantments.registerObject("paper_brain") { PaperBrainEnchantment }
    val ShockTherapy by Enchantments.registerObject("shock_therapy") { ShockTherapyEnchantment }

    // madeofsuffering
    val BurningPhobia by Enchantments.registerObject("burning_phobia") { BurningPhobiaEnchantment }
    val ConstrainedHeart by Enchantments.registerObject("constrained_heart") { ConstrainedHeartEnchantment }
    val DestructionWorship by Enchantments.registerObject("destruction_worship") { DestructionWorshipEnchantment }
    val DrowningPhobia by Enchantments.registerObject("drowning_phobia") { DrowningPhobiaEnchantment }
    val PiercingFever by Enchantments.registerObject("piercing_fever") { PiercingFeverEnchantment }
    val PrayerOfPain by Enchantments.registerObject("prayer_of_pain") { PrayerOfPainEnchantment }

    // rootedinhatred
    val FreshRevenge by Enchantments.registerObject("fresh_revenge") { FreshRevengeEnchantment }
    val HatredBloodline by Enchantments.registerObject("hatred_bloodline") { HatredBloodlineEnchantment }
    val OutrageoutSpirit by Enchantments.registerObject("outrageous_spirit") { OutrageoutSpiritEnchantment }
    val ResentfulSou by Enchantments.registerObject("resentful_soul") { ResentfulSoulEnchantment }
    val TooResentfulToDie by Enchantments.registerObject("too_resentful_to_die") { TooResentfulToDieEnchantment }

    // survivaltricks
    val NecessaryEvil by Enchantments.registerObject("necessary_evil") { NecessaryEvilEnchantment }
    val SurvivalShortcut by Enchantments.registerObject("survival_shortcut") { SurvivalShortcutEnchantment }
    val SurvivalRuse by Enchantments.registerObject("survival_ruse") { SurvivalRuseEnchantment }

    // themistakens
    val BurialObject by Enchantments.registerObject("burial_object") { BurialObjectCurse }
    val CorruptedKindred by Enchantments.registerObject("corrupted_kindred") { CorruptedKindredEnchantment }
    val LightburnFungalParasitic by Enchantments.registerObject("lightburn_fungal_parasitic") { LightburnFungalParasiticEnchantment }
    val OriginalSinErosion by Enchantments.registerObject("original_sin_erosion") { OriginalSinErosionEnchantment }
    val PrototypeChaotic by Enchantments.registerObject("prototype_chaotic") { PrototypeChaoticEnchantment }
    val PrototypeChaoticTypeBeta by Enchantments.registerObject("prototype_chaotic_type_beta") { PrototypeChaoticTypeBetaEnchantment }
    val ScholarOfOriginalSin by Enchantments.registerObject("scholar_of_original_sin") { ScholarOfOriginalSinEnchantment }
    val Shadowborn by Enchantments.registerObject("shadowborn") { ShadowbornEnchantment }
}