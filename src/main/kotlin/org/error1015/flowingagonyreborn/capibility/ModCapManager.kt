package org.error1015.flowingagonyreborn.capibility

import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.common.capabilities.CapabilityToken
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import org.error1015.flowingagonyreborn.MODID

@Mod.EventBusSubscriber
object ModCapManager {
    val AbnormalJoy_Capability: Capability<AbnormalJoyCapability> = CapabilityManager.get(object : CapabilityToken<AbnormalJoyCapability>() {})
    val CoolDown_Capability: Capability<CoolDown> = CapabilityManager.get(object : CapabilityToken<CoolDown>() {})
    val HatredBloodlineStatus_Capability: Capability<HatredBloodlineStatusCapability> = CapabilityManager.get(object : CapabilityToken<HatredBloodlineStatusCapability>() {})
    val LastSweetDream_Capability: Capability<LastSweetDreamCapability> = CapabilityManager.get(object : CapabilityToken<LastSweetDreamCapability>() {})

    @SubscribeEvent
    fun attachCap(event: AttachCapabilitiesEvent<Entity>) {
        val entity = event.`object`
        if (entity is Player) {
            val provider = PlayerCapabilityProvider()
            event.addCapability(ResourceLocation(MODID, "player_capability"), provider)
            event.addListener(provider::invalidate)
        }
    }

    @SubscribeEvent
    fun migrateCapDataWhenPlayerRespawn(event: PlayerEvent.Clone) {
        val player = event.entity
        if (player.level().isClientSide || event.isCanceled) return

        val oldHatredBloodStatus = event.original.getCapability(HatredBloodlineStatus_Capability)
        val newHatredBloodStatus = player.getCapability(HatredBloodlineStatus_Capability)
        if (oldHatredBloodStatus.isPresent && newHatredBloodStatus.isPresent) {
            newHatredBloodStatus.ifPresent { newCap -> oldHatredBloodStatus.ifPresent { oldCap -> newCap.setActiveLevel(oldCap.getActiveLevel()) } }
        }

        val oldAbnormalJoyPoint = event.original.getCapability(AbnormalJoy_Capability)
        val newAbnormalJoyPoint = player.getCapability(AbnormalJoy_Capability)
        if (oldAbnormalJoyPoint.isPresent && newAbnormalJoyPoint.isPresent) {
            newAbnormalJoyPoint.ifPresent { newCap -> oldAbnormalJoyPoint.ifPresent { oldCap -> newCap.setPoint(oldCap.getPoint()) } }
        }

        val oldCoolDown = event.original.getCapability(CoolDown_Capability)
        val newCoolDown = player.getCapability(CoolDown_Capability)
        if (oldCoolDown.isPresent && newCoolDown.isPresent) {
            newCoolDown.ifPresent { newCap -> oldCoolDown.ifPresent { oldCap -> newCap.setMap(oldCap.getMap()) } }
        }

        val oldLastSweetDream = event.original.getCapability(LastSweetDream_Capability)
        val newLastSweetDream = player.getCapability(LastSweetDream_Capability)
        if (oldLastSweetDream.isPresent && newLastSweetDream.isPresent) {
            newLastSweetDream.ifPresent { newCap -> oldLastSweetDream.ifPresent { oldCap -> newCap.saveItemStack(oldCap.getItemStack()) } }
        }
    }
}