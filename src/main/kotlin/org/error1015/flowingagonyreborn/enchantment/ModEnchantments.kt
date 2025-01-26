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
}