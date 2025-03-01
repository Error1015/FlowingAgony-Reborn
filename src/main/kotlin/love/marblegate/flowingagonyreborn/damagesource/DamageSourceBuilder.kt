package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.Level
import net.minecraft.world.phys.Vec3

object DamageSourceBuilder {
    fun createDamageSource(key: ResourceKey<DamageType>, directEntity: Entity, causingEntity: Entity): DamageSource {
        val registryAccess = directEntity.level().registryAccess()
        val holderOrThrow = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
        return DamageSource(holderOrThrow, causingEntity, directEntity)
    }

    fun createDamageSource(key: ResourceKey<DamageType>, level: Level): DamageSource {
        val registryAccess = level.registryAccess()
        val holderOrThrow = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
        return DamageSource(holderOrThrow)
    }

    fun createDamageSource(key: ResourceKey<DamageType>, entity: Entity): DamageSource {
        val registryAccess = entity.level().registryAccess()
        val holderOrThrow = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
        return DamageSource(holderOrThrow, entity)
    }

    fun createDamageSource(key: ResourceKey<DamageType>, directEntity: Entity, causingEntity: Entity, vec3: Vec3): DamageSource {
        val registryAccess = directEntity.level().registryAccess()
        val holderOrThrow = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key)
        return DamageSource(holderOrThrow, causingEntity, directEntity, vec3)
    }
}