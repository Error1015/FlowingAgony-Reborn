@file:JvmName("StanderUtil")

package org.error1015.flowingagonyreborn.util

import net.minecraft.world.entity.LivingEntity
import net.minecraftforge.event.entity.living.LivingDamageEvent

/**
 * 如果伤害大于0.1，且伤害来源是实体, 则返回true
 */
fun LivingDamageEvent.shouldReflectDamage() = this.amount > 0.1 && this.source.entity is LivingEntity