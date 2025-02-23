@file:JvmName("EntityUtil")

package love.marblegate.flowingagonyreborn.util

import net.minecraft.world.entity.FlyingMob
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.animal.*
import net.minecraft.world.entity.animal.horse.Llama
import net.minecraft.world.entity.boss.enderdragon.EnderDragon
import net.minecraft.world.entity.boss.wither.WitherBoss
import net.minecraft.world.entity.monster.*
import net.minecraft.world.entity.monster.hoglin.Hoglin
import net.minecraft.world.entity.monster.piglin.Piglin
import net.minecraft.world.entity.player.Player
import net.minecraft.world.phys.AABB
import java.util.function.Predicate

fun LivingEntity.getTargetsExceptOneself(radius: Float, height: Float, predicate: Predicate<LivingEntity>): List<LivingEntity> {
    val aabb = AABB(
        (this.blockPosition().x - radius).toDouble(), (this.blockPosition().y - height).toDouble(), (this.blockPosition().z - radius).toDouble(), (this.blockPosition().x + radius).toDouble(),
        (this.blockPosition().y + height).toDouble(), (this.blockPosition().z + radius).toDouble()
    )

    val entities = this.level().getEntitiesOfClass(LivingEntity::class.java, aabb, predicate)
    entities.remove(this)
    return entities
}

fun Player.getTargetsExceptOneself(radius: Float, height: Float, predicate: Predicate<LivingEntity>): List<LivingEntity> {
    return (this as LivingEntity).getTargetsExceptOneself(radius, height, predicate)
}


fun LivingEntity.getTargetsOfSameType(radius: Float, height: Float, sourceEntity: LivingEntity, excludeOneself: Boolean): List<LivingEntity> {
    val aabb = AABB(
        (this.blockPosition().x - radius).toDouble(), (this.blockPosition().y - height).toDouble(), (this.blockPosition().z - radius).toDouble(), (this.blockPosition().x + radius).toDouble(),
        (this.blockPosition().y + height).toDouble(), (this.blockPosition().z + radius).toDouble()
    )
    val entities = this.level().getEntitiesOfClass(
        LivingEntity::class.java, aabb
    ) { livingEntity -> livingEntity.javaClass == sourceEntity.javaClass }
    if (excludeOneself) entities.remove(this)
    return entities
}

fun LivingEntity.isHostile(restrictMode: Boolean) = when {
    restrictMode -> {
        (this is Monster && this !is Piglin && this !is Spider && this !is EnderMan) || this is Slime || this is FlyingMob || this is Hoglin || this is EnderDragon
    }

    else -> {
        this is Monster || this is Slime || this is FlyingMob || this is Hoglin || this is EnderDragon
    }
}

fun LivingEntity.isNeutral(restrictMode: Boolean): Boolean {
    return if (restrictMode) {
        // 递归调用自身获取基础中立判断 + 额外类型
        this.isNeutral(false) || this is EnderMan || this is Piglin || this is ZombifiedPiglin || this is Spider
    } else {
        // 基础中立生物类型判断
        this is Bee || this is Dolphin || this is IronGolem || this is Wolf || this is Panda || this is PolarBear || this is Llama
    }
}

fun LivingEntity.isAggresiveUndead() = this.isCommonUndead() || this.isRareUndead() || this is WitherBoss

fun LivingEntity.isCommonUndead() = this is Zombie || this is Skeleton

fun LivingEntity.isRareUndead() = this is Phantom || this is WitherSkeleton || this is Stray

fun LivingEntity.supportHeadDrop() =
    (this is Zombie && this !is ZombieVillager && this !is ZombifiedPiglin && this !is Husk) || (this is Skeleton || this is Creeper || this is EnderDragon || this is WitherSkeleton)

// fun LivingEntity.isPassiveUndead() = this is ZombieHorse || this is SkeletonHorse