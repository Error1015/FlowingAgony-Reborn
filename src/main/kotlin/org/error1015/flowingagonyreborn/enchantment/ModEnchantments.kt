package org.error1015.flowingagonyreborn.enchantment

import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import org.error1015.flowingagonyreborn.MODID
import org.error1015.flowingagonyreborn.enchantment.diceoffraud.*
import org.error1015.flowingagonyreborn.enchantment.flameofenvy.*
import org.error1015.flowingagonyreborn.enchantment.gloomyera.*
import org.error1015.flowingagonyreborn.enchantment.innerpotential.*
import org.error1015.flowingagonyreborn.enchantment.lastwish.GuidensRegretEnchantment
import org.error1015.flowingagonyreborn.enchantment.lastwish.LastSweetDreamEnchantment
import org.error1015.flowingagonyreborn.enchantment.lastwish.MorirsDeathwishEnchantment
import org.error1015.flowingagonyreborn.enchantment.lastwish.MorirsLifeboundEnchantment
import org.error1015.flowingagonyreborn.enchantment.lensofmalice.*
import org.error1015.flowingagonyreborn.enchantment.madeofmadness.*
import org.error1015.flowingagonyreborn.enchantment.madeofsuffering.*
import org.error1015.flowingagonyreborn.enchantment.rootedinhatred.*
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
}