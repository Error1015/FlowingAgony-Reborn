package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.core.Holder
import net.minecraft.network.chat.Component
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity

class FlowingAgonyMobtoMobDamageSource(
    holder: Holder<DamageType>, entity: Entity
) : DamageSource(holder, entity) {
    override fun getLocalizedDeathMessage(pLivingEntity: LivingEntity): Component {
        val s = "death.attack.$msgId"
        return Component.translatable(s, pLivingEntity.displayName, entity?.displayName)
    }
}