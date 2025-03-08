package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.NecessaryEvilEnchantment
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.SurvivalRuseEnchantment
import love.marblegate.flowingagonyreborn.enchantment.survivaltricks.SurvivalShortcutEnchantment
import love.marblegate.flowingagonyreborn.util.getEnchantmentLevel
import love.marblegate.flowingagonyreborn.util.getTargetsExceptOneself
import love.marblegate.flowingagonyreborn.util.isHostile
import net.minecraft.util.RandomSource
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber
object SurvivalTricksEnchantmentEventHandler {
    @SubscribeEvent(priority = EventPriority.LOW)
    fun doSurvivalShortcutEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level.isClientSide) return
        if (event.source != DamageSource.OUT_OF_WORLD && event.source.msgId != "burial_object_curse") {
            if (event.entity is Player) {
                val player = event.entity as Player
                val enchantmentLevel = player.getEnchantmentLevel(SurvivalShortcutEnchantment, EquipmentSlot.CHEST)
                if (enchantmentLevel == 0) return
                if (event.source.entity is Player) event.amount *= 0.95f - 0.05f * enchantmentLevel
                else if (event.amount >= 9 - enchantmentLevel) {
                    var entities: List<LivingEntity> = if (Config.generalSettings.villagerSafeMode.get()) player.getTargetsExceptOneself(16f, 2f) {
                        !it.isHostile(false) && it !is Villager
                    } else player.getTargetsExceptOneself(16f, 2f) {
                        !it.isHostile(false)
                    }
                    damageTransfer(entities, event, enchantmentLevel, false)
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    fun doSurvivalSRuseEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level.isClientSide) return
        if (event.source != DamageSource.OUT_OF_WORLD && event.source.msgId != "burial_object_curse") {
            if (event.entity is Player) {
                val player = event.entity as Player
                val enchantmentLevel = player.getEnchantmentLevel(SurvivalRuseEnchantment, EquipmentSlot.CHEST)
                if (enchantmentLevel == 0) return
                if (event.source.entity is Player) event.amount *= 0.95F - 0.05F * enchantmentLevel
                else if (event.amount >= 9 - enchantmentLevel) {
                    val entities = player.getTargetsExceptOneself(16f, 2f) { it.isHostile(false) }
                    damageTransfer(entities, event, enchantmentLevel, false)
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    fun doNecessaryEvilEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level.isClientSide) return
        if (event.source != DamageSource.OUT_OF_WORLD && event.source.msgId != "burial_object_curse") {
            if (event.entity is Player) {
                val player = event.entity as Player
                val enchantmentLevel = player.getEnchantmentLevel(NecessaryEvilEnchantment, EquipmentSlot.CHEST)
                if (enchantmentLevel == 0) return
                if (event.source.entity is Player) event.amount *= 0.85F - 0.05F * enchantmentLevel
                else if (event.amount >= 13 - enchantmentLevel) {
                    val entities = if (Config.generalSettings.villagerSafeMode.get()) player.getTargetsExceptOneself(16f, 2f) { it !is Player && it !is Villager }
                    else player.getTargetsExceptOneself(
                        16f, 2f
                    ) { it !is Player }
                    damageTransfer(entities, event, enchantmentLevel, true)
                }
            }
        }
    }

    private fun damageTransfer(
        entities: List<LivingEntity>, event: LivingDamageEvent, level: Int, shareMode: Boolean
    ) {
        if (!entities.isEmpty()) {
            if (shareMode) {
                val damageSharedPerEntity = event.amount / entities.size
                entities.forEach { it.hurt(DamageSource.GENERIC, damageSharedPerEntity) }
            } else {
                var target: LivingEntity = if (entities.size == 1) entities[0] else getLuckyOne(entities, event.entity.random)
                target.hurt(DamageSource.GENERIC, event.amount)
            }
            event.isCanceled = true
        } else {
            if (event.source.isExplosion) {
                event.amount *= if (shareMode) 0.7f - level * 0.1f else 0.9f - level * 0.1f
            } else {
                event.amount *= if (shareMode) 0.85f - level * 0.05f else 0.95f - level * 0.05f
            }
        }
    }

    /**
     * 在一个LivingEntity的集合中随机抽取一个幸运儿
     */
    private fun getLuckyOne(entities: List<LivingEntity>, source: RandomSource) = entities[source.nextInt(entities.size)]
}