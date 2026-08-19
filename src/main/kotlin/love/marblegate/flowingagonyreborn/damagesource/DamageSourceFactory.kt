package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity

object DamageSourceFactory {
    fun causeCursedHatredDamage(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursed_hatred, registryAccess)

    fun causeCursedAntipathyDamage(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursed_antipathy_effect, registryAccess)

    fun causeLightburnFungalInfection(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.lightburn_fungal_infection, registryAccess)

    fun causeAgonyResonance(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.agony_resonance, registryAccess)

    fun causeRythmOfUniverse(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.rhythm_of_universe, registryAccess)

    fun causeExtremeHatred(registryAccess: RegistryAccess) =
        createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.exotic_healer, registryAccess)

    fun causeCuttingWaterMelonDream(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.cutting_watermelon_dream, entity)

    fun causeLetMeSavorItDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.let_me_savor_it, entity)

    fun causeBurialObjectDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.burial_object_curse, entity)

    // see https://github.com/MarbleGateKeeper/FlowingAgony/issues/9
    // if (entity is Guardian) return createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity).magic()
    fun causePhobiaDamage(entity: Entity): DamageSource = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity)

    fun createFlowingAgonySimpleDeathMessageDamageSource(
        key: ResourceKey<DamageType>, registryAccess: RegistryAccess
    ): DamageSource = FlowingAgonySimpleDeathMessageDamageSource(
        registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
    )

    fun createFlowingAgonyMobtoMobDamageSource(
        key: ResourceKey<DamageType>, entity: Entity
    ): DamageSource = FlowingAgonyMobtoMobDamageSource(
        entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key), entity
    )

    internal fun createBasicDamageSource(
        key: ResourceKey<DamageType>, registryAccess: RegistryAccess
    ): DamageSource = DamageSource(
        registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
    )
}