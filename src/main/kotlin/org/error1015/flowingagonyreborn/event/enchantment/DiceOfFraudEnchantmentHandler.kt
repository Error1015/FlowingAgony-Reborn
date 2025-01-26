package org.error1015.flowingagonyreborn.event.enchantment

import net.minecraft.world.entity.LivingEntity
import net.minecraftforge.event.entity.player.AttackEntityEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.error1015.flowingagonyreborn.enchantment.ModEnchantments
import org.error1015.flowingagonyreborn.util.allArmorHasEnchantment

@Mod.EventBusSubscriber
object DiceOfFraudEnchantmentHandler {/* @SubscribeEvent
    fun doTricksterEnchantmentEvent(event: AttackEntityEvent) {
        if (event.entity.level().isClientSide) return
        if (event.target is LivingEntity) {

        }
    } */

    /* @SubscribeEvent
    fun doAnEnchantedGoldenAppleADayEnchantmentEvent(event: PlayerEvent.PlayerChangeGameModeEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity.allArmorHasEnchantment(ModEnchantments.anEnchantedGoldenAppleADay)) {
            // event.entity.getCapability() TODO: Capability
        }
    } */
}