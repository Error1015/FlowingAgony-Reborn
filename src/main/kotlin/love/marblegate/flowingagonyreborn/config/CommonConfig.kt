package love.marblegate.flowingagonyreborn.config

import net.minecraftforge.common.ForgeConfigSpec

class CommonConfig {
    companion object {
        var spec: ForgeConfigSpec
        private val builder = ForgeConfigSpec.Builder()
        var generalSettings: GeneralSettings
        var optionalBugFix: OptionalBugFix
        var numericalSettings: NumericalSettings

        init {
            builder
                .comment("General Settings")
                .push("general")
            generalSettings = GeneralSettings(builder)
            builder.pop()

            builder
                .comment(
                    "Enchantment Acquirable Setting", "If you set certain item to \"false\", the relevant enchantment will become not acquirable to survival mode player.",
                    "Enchantment which is acquirable is still functional."
                )
                .push("Optional Bug Fix")
            optionalBugFix = OptionalBugFix(builder)
            builder.pop()
            builder
                .comment("Numerical Value Settings")
                .push("Numerical")
            numericalSettings = NumericalSettings(builder)
            builder.pop()
            spec = builder.build()
        }
    }

    class GeneralSettings(builder: ForgeConfigSpec.Builder) {
        val villagerSafeMode: ForgeConfigSpec.BooleanValue = builder
            .comment(
                "If it's set to \"true\", \"Lightburn Fungal Parasitic\" cannot spread negative effect to villager,",
                "and \"Survival Shortcut\", \"Necessary Evil\", \"Pilferage Creed\" cannot damage villager."
            )
            .define("villagerSafeMode", false)

        val insanePoetDamageReduction: ForgeConfigSpec.DoubleValue = builder
            .comment(
                "The attack damage reduction ratio of \"Insane Poet\". Default value is 0.9, which means the attack damage will be decreased by 90%."
            )
            .defineInRange("insanePoetDamageReduction", 0.9, 0.0, 1.0)

        val shockTherapyDamageReduction: ForgeConfigSpec.DoubleValue = builder
            .comment(
                "The attack damage reduction ratio of \"Shock Therapy\". Default value is 0.9, which means the attack damage will be decreased by 90%."
            )
            .defineInRange("shockTherapyDamageReduction", 0.9, 0.0, 1.0)

        val paperBrainDamageReduction: ForgeConfigSpec.DoubleValue = builder
            .comment(
                "The attack damage reduction ratio of \"Paper Brain\". Default value is 0.9, which means the attack damage will be decreased by 90%."
            )
            .defineInRange("paperBrainDamageReduction", 0.9, 0.0, 1.0)
    }

    class OptionalBugFix(builder: ForgeConfigSpec.Builder) {
        val isFixEnviousKind: ForgeConfigSpec.BooleanValue = builder
            .comment(
                "This entry is for a bug, The EnviousKind Enchantment will Add bigger than 10 level Envious Being Effect", "If you are modpack author, You Should Set to True"
            )
            .define("isFixEnviousKind", true)
    }

    /**
     * 此处是相关数值配置
     */
    class NumericalSettings(builder: ForgeConfigSpec.Builder) {
        val hatredBloodlineEffect: ForgeConfigSpec.DoubleValue = builder.defineInRange("HatredBloodlineEffect", 1.0, 0.0, Double.MAX_VALUE)
        val cursedHatredEffect: ForgeConfigSpec.DoubleValue = builder.defineInRange("HatredBloodlineEffect", 1.0, 0.0, Double.MAX_VALUE)
        val curseOfUndeadEffect: ForgeConfigSpec.DoubleValue = builder.defineInRange("CurseOfUndeadEffect", 1.0, 0.0, Double.MAX_VALUE)
        val beenResonatedEffect: ForgeConfigSpec.DoubleValue = builder.defineInRange("BeenResonatedEffect", 1.0, 0.0, Double.MAX_VALUE)
        val extremeHatredEffect: ForgeConfigSpec.DoubleValue = builder.defineInRange("ExtremeHatredEffect", 1.0, 0.0, Double.MAX_VALUE)
        val letMeSavorItEffectReduceDamage: ForgeConfigSpec.DoubleValue = builder.defineInRange("LetMeSavorItEffectReduceDamage", 1.0, 0.0, Double.MAX_VALUE)
        val letMeSavorItEffectReflectDamage: ForgeConfigSpec.DoubleValue = builder.defineInRange("LetMeSavorItEffectReflectDamage", 1.0, 0.0, Double.MAX_VALUE)
        val phobiaEffectDamage: ForgeConfigSpec.DoubleValue = builder.defineInRange("PhobiaEffectDamage", 1.0, 0.0, Double.MAX_VALUE)
        val savorTheTastedEnchantment: ForgeConfigSpec.DoubleValue = builder.defineInRange("SavorTheTastedEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val armorUpEnchantment: ForgeConfigSpec.IntValue = builder
            .comment("the absorption amount to add")
            .defineInRange("ArmorUpEnchantment", 1, 0, Int.MAX_VALUE)
        val anAppleADayCoolDowns: ForgeConfigSpec.IntValue = builder
            .comment("default 18000, about 5 minutes")
            .defineInRange("anAppleADayCoolDowns", 180000, 0, Int.MAX_VALUE)
        val morirsDeathwishEnchantmentOnHurt: ForgeConfigSpec.DoubleValue = builder.defineInRange("morirsDeathwishEnchantmentOnHurtFix", 1.0, 0.0, Double.MAX_VALUE)
        val morirsDeathwishEnchantmentOnDeathValue: ForgeConfigSpec.IntValue = builder.defineInRange("morirsDeathwishEnchantmentOnDeathFix", 64, 0, Int.MAX_VALUE)
        val morirsLifeboundOnHeal: ForgeConfigSpec.DoubleValue = builder.defineInRange("morirsLifeboundOnHeal", 1.0, 0.0, Double.MAX_VALUE)
        val guidensRegret: ForgeConfigSpec.DoubleValue = builder.defineInRange("GuidensRegret", 1.0, 0.0, Double.MAX_VALUE)
        val cuttingWatermelonDream: ForgeConfigSpec.DoubleValue = builder.defineInRange("CuttingWatermelonDream", 1.0, 0.0, Double.MAX_VALUE)
        val prayerOfPainEnchantment: ForgeConfigSpec.DoubleValue = builder.defineInRange("PrayerOfPainEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val outrageousSpirit: ForgeConfigSpec.DoubleValue = builder.defineInRange("OutrageousSpiritEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val scholarOfOriginalSinAddWeakness: ForgeConfigSpec.DoubleValue = builder.defineInRange("ScholarOfOriginalSinAddWeakness", 1.0, 0.0, Double.MAX_VALUE)
        val scholarOfOriginalSinDecreaseAttack: ForgeConfigSpec.DoubleValue = builder.defineInRange("ScholarOfOriginalSinDecreaseAttack", 1.0, 0.0, Double.MAX_VALUE)
        val paperBrainHurtDamage: ForgeConfigSpec.DoubleValue = builder.defineInRange("paperBrainHurtDamage", 1.0, 0.0, Double.MAX_VALUE)
    }
}