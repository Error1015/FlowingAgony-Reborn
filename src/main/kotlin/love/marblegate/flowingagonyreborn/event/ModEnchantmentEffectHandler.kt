package love.marblegate.flowingagonyreborn.event

import love.marblegate.flowingagonyreborn.ID
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.item.ItemStack
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.player.PlayerEvent
import kotlin.jvm.optionals.getOrNull

@EventBusSubscriber(modid = ID)
object ModEnchantmentEffectHandler {
    /**
     * 来个苹果
     * 存在问题：ItemCoolDowns的实现有问题，重进游戏将会刷新
     */
    @SubscribeEvent
    fun onDimChangeForAppleADay(event: PlayerEvent.PlayerChangedDimensionEvent) {

        val player = event.entity
        val level = player.level()
        if (level.isClientSide) return
        val access = level.registryAccess()
        val enchantmentLookup = access.lookupOrThrow(Registries.ENCHANTMENT)
        val enchantment = enchantmentLookup[ResourceKey.create(
            Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(ID, "an_enchanted_golden_apple_a_day")
        )].getOrNull() ?: return

        // 获取护甲上附魔总等级和护甲物品
        var totalLevel = 0
        val enchantedArmors = mutableListOf<ItemStack>()

        for (armor in player.armorSlots) {
            if (!armor.isEmpty) {
                val enchantmentLevelOnArmor = armor.getEnchantmentLevel(enchantment)
                if (enchantmentLevelOnArmor > 0) {
                    totalLevel += enchantmentLevelOnArmor
                    enchantedArmors += armor
                }
            }
        }

        if (enchantedArmors.isEmpty()) return
        // 计算cd
        val cd = when (totalLevel) {
            1 -> 20
            2 -> 15
            3 -> 10
            4 -> 5
            else -> 20
        } * 20 * 60

        // 给玩家添加附魔金苹果效果
        val shouldAdd = enchantedArmors.any { armor -> player.cooldowns.isOnCooldown(armor.item)}.not() // 若是有一件护甲在cd中，则不生效
        if (shouldAdd) {
            player.apply {
                this.addEffect(MobEffectInstance(MobEffects.REGENERATION, 400, 1))
                this.addEffect(MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0))
                this.addEffect(MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0))
                this.addEffect(MobEffectInstance(MobEffects.ABSORPTION, 2400, 3))
            }
            // 给护甲添加cd
            for (armor in enchantedArmors) {
                player.cooldowns.addCooldown(armor.item, cd)
            }
        }
    }
}