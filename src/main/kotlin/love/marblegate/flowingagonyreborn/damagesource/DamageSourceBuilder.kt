package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity

object DamageSourceBuilder {
    fun causeCursedHatredDamage(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursedHatred, registryAccess)

    fun causeCursedAntipathyDamage(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursedAntipathyEffect, registryAccess)

    fun causeLightburnFungalInfection(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.lightBurnFungalInfection, registryAccess)

    fun causeAgonyResonance(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.agonyResonance, registryAccess)

    fun causeRythmOfUniverse(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.rhythmOfUniverse, registryAccess)

    fun causeExtremeHatred(registryAccess: RegistryAccess) = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.exoticHealer, registryAccess)

    fun causeCuttingWaterMelonDream(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.cuttingWatermelonDream, entity)

    fun causeLetMeSavorItDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.letMeSavorIt, entity)

    fun causeBurialObjectDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.burialObjectCurse, entity)

    fun causePhobiaDamage(entity: Entity): DamageSource {
        // see https://github.com/MarbleGateKeeper/FlowingAgony/issues/9
        // if (entity is Guardian) return createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity).magic()
        return createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity)
    }

    internal fun createFlowingAgonySimpleDeathMessageDamageSource(
        key: ResourceKey<DamageType>,
        registryAccess: RegistryAccess
    ): DamageSource {
        return FlowingAgonySimpleDeathMessageDamageSource(
            registryAccess
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(key)
        )
    }

    internal fun createFlowingAgonyMobtoMobDamageSource(
        key: ResourceKey<DamageType>,
        entity: Entity
    ): DamageSource {
        return FlowingAgonyMobtoMobDamageSource(
            entity
                .level()
                .registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(key), entity
        )
    }

    internal fun createBasicDamageSource(
        key: ResourceKey<DamageType>,
        registryAccess: RegistryAccess
    ): DamageSource = DamageSource(
        registryAccess
            .registryOrThrow(Registries.DAMAGE_TYPE)
            .getHolderOrThrow(key)
    )

}