package love.marblegate.flowingagonyreborn.event.effect

import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.event.entity.living.MobEffectEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber
object ImplicitEffectEventHandler {
    @SubscribeEvent
    fun doHatredBloodlineEnchantmentActiveEffectEvent(event: LivingHurtEvent) {
        if (event.entity.level.isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            if (player.hasEffect(ModEffects.HATRED_BLOODLINE_ENCHANTMENT_ACTIVE)) {
                val effectLevel = player.getEffect(ModEffects.HATRED_BLOODLINE_ENCHANTMENT_ACTIVE)?.let { it.amplifier + 1 } ?: 0
                event.amount = event.amount * (1f + effectLevel * 0.25f)
            }
        }
    }

    @SubscribeEvent
    fun doCleanMiraculousEscapeSoundFX(event: MobEffectEvent.Expired) {
        if (event.entity.level.isClientSide) return
        if (event.effectInstance?.effect == ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE) {
            val serverPlayer = event.entity as? ServerPlayer ?: return

                Networking.safeSend(PacketDistributor.PLAYER.with {
                    serverPlayer
                }, PlaySoundPacket(PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT, false))
            }

    }
}