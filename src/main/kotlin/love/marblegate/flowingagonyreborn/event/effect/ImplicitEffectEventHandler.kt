package love.marblegate.flowingagonyreborn.event.effect

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.network.Networking
import love.marblegate.flowingagonyreborn.network.packet.PlaySoundPacket
import love.marblegate.flowingagonyreborn.util.handleServer
import love.marblegate.flowingagonyreborn.util.proxy.safeSend
import love.marblegate.flowingagonyreborn.util.safeClassCastAndHandle
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
        event.handleServer {
            event.source.entity.safeClassCastAndHandle<Player> { player ->
                if (player.hasEffect(ModEffects.HATRED_BLOODLINE_ENCHANTMENT_ACTIVE)) {
                    val effectLevel = player
                        .getEffect(ModEffects.HATRED_BLOODLINE_ENCHANTMENT_ACTIVE)
                        ?.let { it.amplifier + 1 } ?: 0
                    if (effectLevel <= 0) return
                    event.amount = event.amount * (1f + effectLevel * 0.25f) * CommonConfig.numericalSettings.hatredBloodlineEffect.toFloat()
                }
            }
        }
    }

    @SubscribeEvent
    fun doCleanMiraculousEscapeSoundFX(event: MobEffectEvent.Expired) {
        event.handleServer {
            if (event.effectInstance?.effect == ModEffects.MIRACULOUS_ESCAPE_ENCHANTMENT_ACTIVE) {
                val serverPlayer = event.entity as? ServerPlayer ?: return
                Networking.safeSend(PacketDistributor.PLAYER.with {
                    serverPlayer
                }, PlaySoundPacket(PlaySoundPacket.ModSoundType.MIRACULOUS_ESCAPE_HEARTBEAT, false))
            }
        }
    }
}