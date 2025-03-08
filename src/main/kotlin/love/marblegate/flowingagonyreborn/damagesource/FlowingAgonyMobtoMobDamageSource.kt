package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.network.chat.Component
import net.minecraft.world.damagesource.EntityDamageSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity

class FlowingAgonyMobtoMobDamageSource(msgId: String, entity: Entity) : EntityDamageSource(msgId, entity) {
    override fun getLocalizedDeathMessage(pLivingEntity: LivingEntity): Component {
        val s = "death.attack.$msgId"
        return Component.translatable(s, pLivingEntity.displayName, entity.displayName)
    }
}