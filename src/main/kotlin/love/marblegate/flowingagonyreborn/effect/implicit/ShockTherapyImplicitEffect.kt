package love.marblegate.flowingagonyreborn.effect.implicit

import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity


object ShockTherapyImplicitEffect : HarmfulBlankImplicitEffect() {
    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        val lightningBolt = EntityType.LIGHTNING_BOLT.create(pLivingEntity.level()) ?: return
        lightningBolt.setPos(pLivingEntity.x, pLivingEntity.y, pLivingEntity.z)
        lightningBolt.setVisualOnly(true)
        pLivingEntity.level().addFreshEntity(lightningBolt)
        pLivingEntity.hurt(pLivingEntity.level().damageSources().lightningBolt()/* 穿透护甲的伤害 */, (pLivingEntity.random.nextInt(3) + 2).toFloat())
    }

    override fun isDurationEffectTick(duration: Int, amplifier: Int): Boolean {
        val k = 10
        return if (duration > 0) {
            duration % k == 0
        } else false
    }
}