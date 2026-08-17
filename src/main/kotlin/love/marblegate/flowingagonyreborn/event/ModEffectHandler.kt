package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.effect.ModEffects
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent

@EventBusSubscriber(modid = ID)
object ModEffectHandler {
    /**
     * 仇恨诅咒实现效果
     * 在受到攻击时，将额外受到仇恨伤害 2/4/6/8/10 点。玩家受到的额外伤害随机减免10%-20%。
     */
    @SubscribeEvent
    fun handleCursedHatred(event: LivingDamageEvent.Pre) {
        val livingEntity = event.entity
        val cursedHatred = livingEntity.getEffect(ModEffects.cursedHatred) ?: return
        val originalDamage = event.originalDamage
        val effectLevel = if (cursedHatred.amplifier <= 4) cursedHatred.amplifier + 1 else 5 // 获取效果等级，并设置上限为5
        val extraDamage = 2 * effectLevel
        if (livingEntity.level().isClientSide) return
        if (livingEntity is Player) {
            val player: Player = livingEntity
            val randomDamageExemption = 0.8f + player.level().random.nextFloat() * 0.1f // 伤害在原来的在0.8到0.9之间
            event.newDamage = originalDamage + extraDamage * randomDamageExemption
        } else {
            event.newDamage = originalDamage + extraDamage
        }
    }

}