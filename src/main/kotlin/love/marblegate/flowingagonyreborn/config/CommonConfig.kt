package love.marblegate.flowingagonyreborn.config

import love.marblegate.flowingagonyreborn.util.getValue
import net.minecraftforge.common.ForgeConfigSpec

class CommonConfig {
    companion object {
        var spec: ForgeConfigSpec
        private val builder = ForgeConfigSpec.Builder()
        var generalSettings: GeneralSettings
        var optionalBugFix: OptionalBugFix
        var numericalSettings: NumericalSettings

        init {
            builder.comment("General Settings").push("general")
            generalSettings = GeneralSettings(builder)
            builder.pop()

            builder.comment(
                "Enchantment Acquirable Setting", "If you set certain item to \"false\", the relevant enchantment will become not acquirable to survival mode player.",
                "Enchantment which is acquirable is still functional."
            ).push("Optional Bug Fix")
            optionalBugFix = OptionalBugFix(builder)
            builder.pop()
            builder.comment("Numerical Value Settings").push("Numerical")
            numericalSettings = NumericalSettings(builder)
            builder.pop()
            spec = builder.build()
        }
    }

    class GeneralSettings(builder: ForgeConfigSpec.Builder) {
        val villagerSafeMode: ForgeConfigSpec.BooleanValue = builder.comment(
            "If it's set to \"true\", \"Lightburn Fungal Parasitic\" cannot spread negative effect to villager,",
            "and \"Survival Shortcut\", \"Necessary Evil\", \"Pilferage Creed\" cannot damage villager."
        ).define("villagerSafeMode", false)

        val insanePoetDamageReduction by builder.comment(
            "The attack damage reduction ratio of \"Insane Poet\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("insanePoetDamageReduction", 0.9, 0.0, 1.0)

        val shockTherapyDamageReduction by builder.comment(
            "The attack damage reduction ratio of \"Shock Therapy\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("shockTherapyDamageReduction", 0.9, 0.0, 1.0)

        val paperBrainDamageReduction by builder.comment(
            "The attack damage reduction ratio of \"Paper Brain\". Default value is 0.9, which means the attack damage will be decreased by 90%."
        ).defineInRange("paperBrainDamageReduction", 0.9, 0.0, 1.0)
    }

    class OptionalBugFix(builder: ForgeConfigSpec.Builder) {
        val isFixEnviousKind: ForgeConfigSpec.BooleanValue = builder.comment(
            "This entry is for a bug, The EnviousKind Enchantment will Add bigger than 10 level Envious Being Effect", "If you are modpack author, You Should Set to True"
        ).define("isFixEnviousKind", true)
    }

    /**
     * 此处是相关数值配置
     */
    class NumericalSettings(builder: ForgeConfigSpec.Builder) {
        val hatredBloodlineEffect by builder.defineInRange("HatredBloodlineEffect", 1.0, 0.0, Double.MAX_VALUE)
        val cursedHatredEffect by builder.defineInRange("HatredBloodlineEffect", 1.0, 0.0, Double.MAX_VALUE)
        val curseOfUndeadEffect by builder.defineInRange("CurseOfUndeadEffect", 1.0, 0.0, Double.MAX_VALUE)
        val beenResonatedEffect by builder.defineInRange("BeenResonatedEffect", 1.0, 0.0, Double.MAX_VALUE)
        val extremeHatredEffect by builder.defineInRange("ExtremeHatredEffect", 1.0, 0.0, Double.MAX_VALUE)
        val letMeSavorItEffectReduceDamage by builder.defineInRange("LetMeSavorItEffectReduceDamage", 1.0, 0.0, Double.MAX_VALUE)
        val letMeSavorItEffectReflectDamage by builder.defineInRange("LetMeSavorItEffectReflectDamage", 1.0, 0.0, Double.MAX_VALUE)
        val phobiaEffectDamage by builder.defineInRange("PhobiaEffectDamage", 1.0, 0.0, Double.MAX_VALUE)
        val savorTheTastedEnchantment by builder.defineInRange("SavorTheTastedEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val armorUpEnchantment by builder.comment("the absorption amount to add").defineInRange("ArmorUpEnchantment", 1, 0, Int.MAX_VALUE)
        val anAppleADayCoolDowns by builder.comment("default 18000, about 5 minutes").defineInRange("anAppleADayCoolDowns", 180000, 0, Int.MAX_VALUE)
        val morirsDeathwishEnchantmentOnHurt by builder.defineInRange("morirsDeathwishEnchantmentOnHurtFix", 1.0, 0.0, Double.MAX_VALUE)
        val morirsDeathwishEnchantmentOnDeathValue by builder.defineInRange("morirsDeathwishEnchantmentOnDeathFix", 64, 0, Int.MAX_VALUE)
        val morirsLifeboundOnHeal by builder.defineInRange("morirsLifeboundOnHeal", 1.0, 0.0, Double.MAX_VALUE)
        val guidensRegret by builder.defineInRange("GuidensRegret", 1.0, 0.0, Double.MAX_VALUE)
        val cuttingWatermelonDream by builder.defineInRange("CuttingWatermelonDream", 1.0, 0.0, Double.MAX_VALUE)
        val prayerOfPainEnchantment by builder.defineInRange("PrayerOfPainEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val outrageousSpirit by builder.defineInRange("OutrageousSpiritEnchantment", 1.0, 0.0, Double.MAX_VALUE)
        val scholarOfOriginalSinAddWeakness by builder.defineInRange("ScholarOfOriginalSinAddWeakness", 1.0, 0.0, Double.MAX_VALUE)
        val scholarOfOriginalSinDecreaseAttack by builder.defineInRange("ScholarOfOriginalSinDecreaseAttack", 1.0, 0.0, Double.MAX_VALUE)
        val paperBrainHurtDamage by builder.defineInRange("paperBrainHurtDamage", 1.0, 0.0, Double.MAX_VALUE)
    }
}