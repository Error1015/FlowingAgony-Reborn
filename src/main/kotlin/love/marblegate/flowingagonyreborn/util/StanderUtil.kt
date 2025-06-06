@file:JvmName("StanderUtil")

package love.marblegate.flowingagonyreborn.util

import net.minecraft.world.entity.LivingEntity
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent

/**
 * 如果伤害大于0.1，且伤害来源是实体, 则返回true
 */
fun LivingDamageEvent.Post.shouldReflectDamage() = originalDamage > 0.1 && source.entity is LivingEntity