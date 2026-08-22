package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.ID
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.util.hasHelmet
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Items
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.EffectCure
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent
import net.neoforged.neoforge.event.tick.PlayerTickEvent

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

    /**
     * 玩家食用附魔金苹果的时候清除亡灵诅咒，食用腐肉回血和给3秒力量
     */
    @SubscribeEvent
    fun removeCurseOfUndeadEffectByEating(event: LivingEntityUseItemEvent.Finish) {
        val player = (event.entity as? Player ?: return).apply {
            if (level().isClientSide) {
                return
            }
        }
        if (player.hasEffect(ModEffects.curseOfUndeadEffect)) {
            if (event.item.`is`(Items.ENCHANTED_GOLDEN_APPLE)) {
                player.removeEffectsCuredBy(EffectCure.get("enchanted_golden_apple"))

            } else if (event.item.`is`(Items.ROTTEN_FLESH)) {
                player.heal(1f)
                player.addEffect(MobEffectInstance(MobEffects.DAMAGE_BOOST, 60))
            }
        }
    }

    /**
     * 存在亡灵诅咒的时候着火逻辑
     */
    @SubscribeEvent
    fun doCurseOfUndeadEffectApplyFire(event: PlayerTickEvent.Pre) {
        val player = event.entity
        val level = player.level()
        val isSunny = !level.isRaining
        if (level.isClientSide) {
            return
        }
        if (player.hasEffect(ModEffects.curseOfUndeadEffect) && level.isDay && isSunny && level.canSeeSky(player.blockPosition())) {
            if (!player.hasHelmet()) {
                player.remainingFireTicks = 5
            }
        }
    }


}