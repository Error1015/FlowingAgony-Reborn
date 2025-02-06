package org.error1015.flowingagonyreborn

import net.minecraftforge.common.ForgeConfigSpec

class Config {
    companion object {
        var actConfig: ForgeConfigSpec
        private val builder = ForgeConfigSpec.Builder()
        val generalSettings: GeneralSettings = GeneralSettings(builder)
        val acquirableSettings: AcquirableSettings = AcquirableSettings(builder)

        init {
            builder.comment("General Settings").push("general")
            builder.pop()
            builder.comment(
                    "Enchantment Acquirable Setting", "If you set certain item to \"false\", the relevant enchantment will become not acquirable to survival mode player.",
                    "Enchantment which is acquirable is still functional."
            ).push("acquirable")
            builder.pop()
            actConfig = builder.build()
        }
    }

    class GeneralSettings(builder: ForgeConfigSpec.Builder) {
        val villagerSafeMode: ForgeConfigSpec.BooleanValue = builder.comment(
                "If it's set to \"true\", \"Lightburn Fungal Parasitic\" cannot spread negative effect to villager,",
                "and \"Survival Shortcut\", \"Necessary Evil\", \"Pilferage Creed\" cannot damage villager."
        ).define("villagerSafeMode", false)

        val insanePoetDamageReduction: ForgeConfigSpec.DoubleValue = builder.comment(
                "The attack damage reduction ratio of \"Insane Poet\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("insanePoetDamageReduction", 0.9, 0.0, 1.0)

        val shockTherapyDamageReduction: ForgeConfigSpec.DoubleValue = builder.comment(
                "The attack damage reduction ratio of \"Shock Therapy\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("shockTherapyDamageReduction", 0.9, 0.0, 1.0)

        val paperBrainDamageReduction: ForgeConfigSpec.DoubleValue = builder.comment(
                "The attack damage reduction ratio of \"Paper Brain\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("paperBrainDamageReduction", 0.9, 0.0, 1.0)
    }

    class AcquirableSettings(builder: ForgeConfigSpec.Builder) {
        val anEnchantedGoldenAppleADay: ForgeConfigSpec.BooleanValue = builder.define("anEnchantedGoldenAppleADay", true)
        val deathPunk: ForgeConfigSpec.BooleanValue = builder.define("deathPunk", true)
        val exoticHealer: ForgeConfigSpec.BooleanValue = builder.define("exoticHealer", true)
        val savorTheTasted: ForgeConfigSpec.BooleanValue = builder.define("savorTheTasted", true)
        val trickster: ForgeConfigSpec.BooleanValue = builder.define("trickster", true)
        val covertKnife: ForgeConfigSpec.BooleanValue = builder.define("covertKnife", true)
        val enviousKind: ForgeConfigSpec.BooleanValue = builder.define("enviousKind", true)
        val eyesore: ForgeConfigSpec.BooleanValue = builder.define("eyesore", true)
        val sourceOfEnvy: ForgeConfigSpec.BooleanValue = builder.define("sourceOfEnvy", true)
        val thornInFlesh: ForgeConfigSpec.BooleanValue = builder.define("thornInFlesh", true)
        val cleansingBeforeUsing: ForgeConfigSpec.BooleanValue = builder.define("cleansingBeforeUsing", true)
        val comeBackAtDusk: ForgeConfigSpec.BooleanValue = builder.define("comeBackAtDusk", true)
        val dirtyMoney: ForgeConfigSpec.BooleanValue = builder.define("dirtyMoney", true)
        val pilferageCreed: ForgeConfigSpec.BooleanValue = builder.define("pilferageCreed", true)
        val carefullyIdentified: ForgeConfigSpec.BooleanValue = builder.define("carefullyIdentified", true)
        val nimbleFinger: ForgeConfigSpec.BooleanValue = builder.define("nimbleFinger", true)
        val regularCustomerProgram: ForgeConfigSpec.BooleanValue = builder.define("regularCustomerProgram", true)
        val armorUp: ForgeConfigSpec.BooleanValue = builder.define("armorUp", true)
        val frivolousStep: ForgeConfigSpec.BooleanValue = builder.define("frivolousStep", true)
        val miraculousEscape: ForgeConfigSpec.BooleanValue = builder.define("miraculousEscape", true)
        val potentialBurst: ForgeConfigSpec.BooleanValue = builder.define("potentialBurst", true)
        val stubbornStep: ForgeConfigSpec.BooleanValue = builder.define("stubbornStep", true)
        val infectiousMalice: ForgeConfigSpec.BooleanValue = builder.define("infectiousMalice", true)
        val iSeeYouNow: ForgeConfigSpec.BooleanValue = builder.define("iSeeYouNow", true)
        val maliceOutbreak: ForgeConfigSpec.BooleanValue = builder.define("maliceOutbreak", true)
        val perceivedMalice: ForgeConfigSpec.BooleanValue = builder.define("perceivedMalice", true)
        val vengeance: ForgeConfigSpec.BooleanValue = builder.define("vengeance", true)
        val backAndFill: ForgeConfigSpec.BooleanValue = builder.define("backAndFill", true)
        val agonyScreamer: ForgeConfigSpec.BooleanValue = builder.define("agonyScreamer", true)
        val cuttingWatermelonDream: ForgeConfigSpec.BooleanValue = builder.define("cuttingWatermelonDream", true)
        val insanePoet: ForgeConfigSpec.BooleanValue = builder.define("insanePoet", true)
        val paperBrain: ForgeConfigSpec.BooleanValue = builder.define("paperBrain", true)
        val shockTherapy: ForgeConfigSpec.BooleanValue = builder.define("shockTherapy", true)
        val burningPhobia: ForgeConfigSpec.BooleanValue = builder.define("burningPhobia", true)
        val constrainedHeart: ForgeConfigSpec.BooleanValue = builder.define("constrainedHeart", true)
        val drowningPhobia: ForgeConfigSpec.BooleanValue = builder.define("drowningPhobia", true)
        val piercingFever: ForgeConfigSpec.BooleanValue = builder.define("piercingFever", true)
        val destructionWorship: ForgeConfigSpec.BooleanValue = builder.define("destructionWorship", true)
        val prayerOfPain: ForgeConfigSpec.BooleanValue = builder.define("prayerOfPain", true)
        val freshRevenge: ForgeConfigSpec.BooleanValue = builder.define("freshRevenge", true)
        val hatredBloodline: ForgeConfigSpec.BooleanValue = builder.define("hatredBloodline", true)
        val outrageousSpirit: ForgeConfigSpec.BooleanValue = builder.define("outrageousSpirit", true)
        val resentfulSoul: ForgeConfigSpec.BooleanValue = builder.define("resentfulSoul", true)
        val tooResentfulToDie: ForgeConfigSpec.BooleanValue = builder.define("tooResentfulToDie", true)
        val morirsDeathwish: ForgeConfigSpec.BooleanValue = builder.define("morirsDeathwish", true)
        val morirsLifebound: ForgeConfigSpec.BooleanValue = builder.define("morirsLifebound", true)
        val guidensRegret: ForgeConfigSpec.BooleanValue = builder.define("guidensRegret", true)
        val lastSweetDream: ForgeConfigSpec.BooleanValue = builder.define("lastSweetDream", true)
        val necessaryEvil: ForgeConfigSpec.BooleanValue = builder.define("necessaryEvil", true)
        val survivalRuse: ForgeConfigSpec.BooleanValue = builder.define("survivalRuse", true)
        val survivalShortcut: ForgeConfigSpec.BooleanValue = builder.define("survivalShortcut", true)
        val corruptedKindred: ForgeConfigSpec.BooleanValue = builder.define("corruptedKindred", true)
        val lightburnFungalParasitic: ForgeConfigSpec.BooleanValue = builder.define("lightburnFungalParasitic", true)
        val prototypeChaotic: ForgeConfigSpec.BooleanValue = builder.define("prototypeChaotic", true)
        val prototypeChaoticTypeBeta: ForgeConfigSpec.BooleanValue = builder.define("prototypeChaoticTypeBeta", true)
        val shadowborn: ForgeConfigSpec.BooleanValue = builder.define("shadowborn", true)
        val scholarOfOriginalSin: ForgeConfigSpec.BooleanValue = builder.define("scholarOfOriginalSin", true)
        val originalSinErosion: ForgeConfigSpec.BooleanValue = builder.define("originalSinErosion", true)
        val burialObject: ForgeConfigSpec.BooleanValue = builder.define("burialObject", true)
    }
}