package love.marblegate.flowingagonyreborn.damagesource

import net.minecraft.network.chat.Component
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.LivingEntity

class FlowingAgonySimpleDeathMessageDamageSource(msgId: String): DamageSource(msgId) {
    override fun getLocalizedDeathMessage(pLivingEntity: LivingEntity): Component {
        val s = "death.attack.$msgId"
        return Component.translatable(s, pLivingEntity.displayName.string)
    }
}