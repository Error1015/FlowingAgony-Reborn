package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.capibility.CoolDown
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import love.marblegate.flowingagonyreborn.enchantment.lastwish.GuidensRegretEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.LastSweetDreamEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.MorirsDeathwishEnchantment
import love.marblegate.flowingagonyreborn.enchantment.lastwish.MorirsLifeboundEnchantment
import love.marblegate.flowingagonyreborn.util.getStackWithEnchantment
import love.marblegate.flowingagonyreborn.util.isItemEnchanted
import net.minecraft.world.Containers
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.item.ItemTossEvent
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.event.entity.living.LivingHealEvent
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import kotlin.math.floor

@Mod.EventBusSubscriber
object LastWishEnchantmentEventHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun doMorirsDeathwishEnchantmentEventMendOnHurt(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player && event.source.type() != DamageTypes.FELL_OUT_OF_WORLD) {
            val player = event.entity as Player
            val stacks = player.getStackWithEnchantment(MorirsDeathwishEnchantment)
            stacks.forEach { stack ->
                var repairPoint = 0
                if (event.amount < 1) {
                    repairPoint += floor(event.amount * player.random.nextInt(3).toInt()).toInt()
                } else {
                    val temp = maxOf(floor(event.amount), 100f).toInt()
                    (0 until temp).forEach { repairPoint += 1 + player.random.nextInt(3) }
                }
                stack.damageValue -= repairPoint
            }
        }
    }

    @SubscribeEvent
    fun doMorirsDeathwishEnchantmentEventMendOnDeath(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val stacks = player.getStackWithEnchantment(MorirsDeathwishEnchantment)
            if (stacks.isEmpty()) return
            val coolDownCapability = player.getCapability(ModCapManager.CoolDown_Capability)
            coolDownCapability.ifPresent { cap ->
                if (cap.isReady(CoolDown.CoolDownType.MORIRS_DEATHWISH_DEATHMENDING)) {
                    stacks.forEach { it.damageValue -= 64 }
                    cap.set(CoolDown.CoolDownType.MORIRS_DEATHWISH_DEATHMENDING, 12000)
                }
            }
        }
    }

    @SubscribeEvent
    fun doMorirsLifeboundEnchantmentEventMendOnHeal(event: LivingHealEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val stacks = player.getStackWithEnchantment(MorirsLifeboundEnchantment)
            stacks.forEach {
                var repairPoint = 0
                if (event.amount < 1) {
                    repairPoint += floor(event.amount * player.random.nextInt(3).toInt()).toInt()
                } else {
                    val temp = maxOf(floor(event.amount), 100f).toInt()
                    (0 until temp).forEach { repairPoint += 1 + player.random.nextInt(3) }
                }
                it.damageValue -= repairPoint
            }
        }
    }

    @SubscribeEvent
    fun doMorirsLifeBoundEnchantmentEventDamageOnDeath(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        if (event.entity is Player) {
            val player = event.entity as Player
            val stacks = player.getStackWithEnchantment(MorirsLifeboundEnchantment)
            stacks.forEach { it.hurtAndBreak(32, player) { } }
        }
    }

    @SubscribeEvent
    fun doGuidensRegretEnchantmentEvent(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val stacks = player.getStackWithEnchantment(GuidensRegretEnchantment)
            stacks.forEach {
                val repairPoint = 1 + player.random.nextInt(3)
                it.damageValue -= repairPoint
            }
        }
    }

    @SubscribeEvent
    fun doLastSweetDreamEnchantmentEventSaveItem(event: ItemTossEvent) {
        val player = event.player
        if (player.level().isClientSide || event.isCanceled) return
        val item = event.entity.item
        if (item.isItemEnchanted(LastSweetDreamEnchantment) && item.isDamageableItem) {
            if (item.damageValue / item.maxDamage > 0.9) {
                val cap = player.getCapability(ModCapManager.LastSweetDream_Capability)
                cap.ifPresent {
                    if (it.isEmpty()) it.saveItemStack(item) else {
                        val oldItem = it.getItemStack()
                        it.clear()
                        it.saveItemStack(item)
                        Containers.dropItemStack(player.level(), player.x.toDouble(), player.y.toDouble(), player.z.toDouble(), oldItem)
                    }
                    event.isCanceled = true
                }
            }
        }
    }

    @SubscribeEvent
    fun doLastSweetDreamEnchantmentEventRetrieveItem(event: PlayerWakeUpEvent) {
        if (event.entity.level().isClientSide || event.isCanceled) return
        val capability = event.entity.getCapability(ModCapManager.LastSweetDream_Capability)
        capability.ifPresent { cap ->
            if (cap.isEmpty()) return@ifPresent
            val savedItem = cap.getItemStack()
            savedItem.damageValue = 0
            Containers.dropItemStack(event.entity.level(), event.entity.x.toDouble(), event.entity.y.toDouble(), event.entity.z.toDouble(), savedItem)
            cap.clear()
        }
    }
}