package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.monster.Guardian

object DamageSourceBuilder {
    val CURSED_HATRED = DamageSource("curse_hatred")
    val CURSED_ANTIPATHY = DamageSource("cursed_antipathy_effect")
    val LIGHTBURN_FUNGAL_INFECTION = DamageSource("lightburn_fungal_infection")
    val AGONY_RESONANCE = DamageSource("agony_resonance")
    val RHYTHM_OF_UNIVERSE = DamageSource("rhythm_of_universe")
    val EXOTIC_HEALER = DamageSource("exotic_healer")

    fun causeCuttingWaterMelonDream(entity: Entity): DamageSource {
        return FlowingAgonyMobtoMobDamageSource("cutting_watermelon_dream", entity)
    }

    fun causeLetMeSavorItDamage(entity: Entity): DamageSource {
        return FlowingAgonyMobtoMobDamageSource("let_me_savor_it", entity)
    }

    fun causeBurialObjectDamage(entity: Entity): DamageSource {
        return FlowingAgonyMobtoMobDamageSource("burial_object_curse", entity).bypassArmor()
    }

    fun causePhobiaDamage(entity: Entity): DamageSource {
        // see https://github.com/MarbleGateKeeper/FlowingAgony/issues/9
        if (entity is Guardian) return FlowingAgonyMobtoMobDamageSource("phobia", entity).setMagic()
        return FlowingAgonyMobtoMobDamageSource("phobia", entity)
    }
}