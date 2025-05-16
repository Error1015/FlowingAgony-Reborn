package love.marblegate.flowingagonyreborn.config

import net.minecraftforge.common.ForgeConfigSpec

class CommonConfig {
    companion object {
        var spec: ForgeConfigSpec
        private val builder = ForgeConfigSpec.Builder()
        var generalSettings: GeneralSettings
        var bugFix: BugFix
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
                .push("bug fix")
            bugFix = BugFix(builder)
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

    class BugFix(builder: ForgeConfigSpec.Builder) {
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
        val hatredBloodlineEffect: ForgeConfigSpec.ConfigValue<Float> = builder.define("HatredBloodlineEffect", 1f)
        val cursedHatredEffect: ForgeConfigSpec.ConfigValue<Float> = builder.define("HatredBloodlineEffect", 1f)
        val curseOfUndeadEffect: ForgeConfigSpec.ConfigValue<Float> = builder.define("CurseOfUndeadEffect", 1f)
        val beenResonatedEffect: ForgeConfigSpec.ConfigValue<Float> = builder.define("BeenResonatedEffect", 1f)
        val extremeHatredEffect: ForgeConfigSpec.ConfigValue<Float> = builder.define("ExtremeHatredEffect", 1f)
        val letMeSavorItEffectReduceDamage: ForgeConfigSpec.ConfigValue<Float> = builder.define("LetMeSavorItEffectReduceDamage", 1f)
        val letMeSavorItEffectReflectDamage: ForgeConfigSpec.ConfigValue<Float> = builder.define("LetMeSavorItEffectReflectDamage", 1f)
        val phobiaEffectDamage: ForgeConfigSpec.ConfigValue<Float> = builder.define("PhobiaEffectDamage", 1f)
        val savorTheTastedEnchantment: ForgeConfigSpec.ConfigValue<Float> = builder.define("SavorTheTastedEnchantment", 1f)
        val armorUpEnchantment: ForgeConfigSpec.ConfigValue<Int> = builder
            .comment("the absorption amount to add")
            .define("ArmorUpEnchantment", 1)
        val anAppleADayCoolDowns: ForgeConfigSpec.ConfigValue<Int> = builder
            .comment("default 18000, about 5 minutes")
            .define("anAppleADayCoolDowns", 18000)
        val morirsDeathwishEnchantmentOnHurt: ForgeConfigSpec.ConfigValue<Float> = builder.define("morirsDeathwishEnchantmentOnHurtFix", 1f)
        val morirsDeathwishEnchantmentOnDeathValue: ForgeConfigSpec.ConfigValue<Int> = builder.define("morirsDeathwishEnchantmentOnDeathFix", 64)
        val morirsLifeboundOnHeal: ForgeConfigSpec.ConfigValue<Float> = builder.define("morirsLifeboundOnHeal", 1f)
        val guidensRegret: ForgeConfigSpec.ConfigValue<Float> = builder.define("GuidensRegret", 1f)
        val cuttingWatermelonDream: ForgeConfigSpec.ConfigValue<Float> = builder.define("CuttingWatermelonDream", 1f)
        val prayerOfPainEnchantment: ForgeConfigSpec.ConfigValue<Float> = builder.define("PrayerOfPainEnchantment", 1f)
        val outrageousSpirit: ForgeConfigSpec.ConfigValue<Float> = builder.define("OutrageousSpiritEnchantment", 1f)
        val scholarOfOriginalSinAddWeakness: ForgeConfigSpec.ConfigValue<Float> = builder.define("ScholarOfOriginalSinAddWeakness", 1f)
        val scholarOfOriginalSinDecreaseAttack: ForgeConfigSpec.ConfigValue<Float> = builder.define("ScholarOfOriginalSinDecreaseAttack", 1f)
        val paperBrainHurtDamage: ForgeConfigSpec.ConfigValue<Float> = builder.define("paperBrainHurtDamage", 1f)
    }
}