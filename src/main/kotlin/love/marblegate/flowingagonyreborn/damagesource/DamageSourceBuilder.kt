package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.core.RegistryAccess
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity
import net.minecraftforge.server.ServerLifecycleHooks

object DamageSourceBuilder {
    internal val registryAccess: RegistryAccess = ServerLifecycleHooks.getCurrentServer().registryAccess()

    val CURSED_HATRED = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursed_hatred)
    val CURSED_ANTIPATHY = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.cursed_antipathy_effect)
    val LIGHTBURN_FUNGAL_INFECTION = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.lightburn_fungal_infection)
    val AGONY_RESONANCE = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.agony_resonance)
    val RYTHM_OF_UNIVERSE = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.rhythm_of_universe)
    val EXOTIC_HEALER = createFlowingAgonySimpleDeathMessageDamageSource(ModDamageTypes.exotic_healer)

    fun causeCuttingWaterMelonDream(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.cutting_watermelon_dream, entity)

    fun causeLetMeSavorItDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.let_me_savor_it, entity)

    fun causeBurialObjectDamage(entity: Entity) = createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.burial_object_curse, entity)

    fun causePhobiaDamage(entity: Entity): DamageSource {
        // see https://github.com/MarbleGateKeeper/FlowingAgony/issues/9
        // if (entity is Guardian) return createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity).magic() 暂无实现方法?
        return createFlowingAgonyMobtoMobDamageSource(ModDamageTypes.phobia, entity)
    }

    internal fun createFlowingAgonySimpleDeathMessageDamageSource(key: ResourceKey<DamageType>): DamageSource {
        return FlowingAgonySimpleDeathMessageDamageSource(registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key))
    }

    internal fun createFlowingAgonyMobtoMobDamageSource(key: ResourceKey<DamageType>, entity: Entity): DamageSource {
        return FlowingAgonyMobtoMobDamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key), entity)
    }

    internal fun createBasicDamageSource(key: ResourceKey<DamageType>): DamageSource {
        return DamageSource(registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key))
    }
}