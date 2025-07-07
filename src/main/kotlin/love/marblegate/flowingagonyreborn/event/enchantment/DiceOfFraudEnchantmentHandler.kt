package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.capibility.CoolDown
import love.marblegate.flowingagonyreborn.capibility.ModCapManager
import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.enchantment.diceoffraud.*
import love.marblegate.flowingagonyreborn.util.*
import net.minecraft.util.Mth
import net.minecraft.world.damagesource.DamageTypes
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.enchantment.EnchantmentHelper
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingHealEvent
import net.minecraftforge.event.entity.player.AttackEntityEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object DiceOfFraudEnchantmentHandler {
    /**
     * 欺诈师
     */
    @SubscribeEvent
    fun doTricksterEnchantmentEvent(event: AttackEntityEvent) {
        if (event.entity.level().isClientSide) return
        val target = event.target ?: return
        val player = event.entity ?: return
        if (target is LivingEntity) {
            val enchantmentLevel = player.getEnchantmentLevel(TricksterEnchantment, EquipmentSlot.MAINHAND)
            val diceNum = target.random.nextInt(5) + 1
            // 使用变量接受另外一个随机点数
            var anotherDiceNum = target.random.nextInt(5) + 1
            when (enchantmentLevel) {
                1 -> appendixEffectForTrickster(target, diceNum)
                2 -> {
                    // 当两个随机数相等的时候，重新生成一个随机数, 直到不相等为止
                    while (diceNum == anotherDiceNum) anotherDiceNum = target.random.nextInt(5) + 1
                    appendixEffectForTrickster(target, diceNum)
                    appendixEffectForTrickster(target, anotherDiceNum)
                }
            }
        }
    }

    /**
     * 给对应随机点数添加上对应的效果
     */
    private fun appendixEffectForTrickster(
        entity: LivingEntity,
        diceNum: Int
    ) {
        when (diceNum) {
            1 -> entity.addEffect(MobEffectInstance(MobEffects.POISON, 100))
            2 -> entity.addEffect(MobEffectInstance(MobEffects.WITHER, 100))
            3 -> entity.addEffect(MobEffectInstance(MobEffects.WEAKNESS, 100))
            4 -> entity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100))
            5 -> entity.setSecondsOnFire(5)
        }
    }

    /**
     * 来个苹果
     */
    @SubscribeEvent
    fun doAnEnchantedGoldenAppleADayEnchantmentEvent(event: PlayerEvent.PlayerChangeGameModeEvent) {
        if (event.entity.level().isClientSide) return
        val player = event.entity ?: return
        val enchantmentLevel = player.getArmorEnchantmentTotalLevel(AnEnchantedGoldenAppleADayEnchantment)
        if (enchantmentLevel == 0) return
        val coolDownCap = event.entity.getCapability(ModCapManager.CoolDown_Capability)
        coolDownCap.ifPresent { cap ->
            if (cap.isReady(CoolDown.CoolDownType.AN_ENCHANTED_GOLDEN_APPLE_A_DAY)) {
                when {
                    enchantmentLevel == 1 -> {
                        val tempNum = player.random.nextInt(4)
                        caseToAddEffect(tempNum, player)
                    }

                    enchantmentLevel < 4 -> {
                        val set = mutableSetOf<Int>()
                        var tempCount = enchantmentLevel
                        while (tempCount > 0) {
                            val tempNum = player.random.nextInt(4)
                            if (tempNum !in set) {
                                caseToAddEffect(tempNum, player)
                                set += tempNum
                                tempCount--
                            }
                        }
                    }

                    enchantmentLevel == 4 -> {
                        player.addEffect(MobEffectInstance(MobEffects.ABSORPTION, 2400, 3))
                        player.addEffect(MobEffectInstance(MobEffects.REGENERATION, 400, 1))
                        player.addEffect(MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000))
                        player.addEffect(MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000))
                    }
                }
                cap.set(CoolDown.CoolDownType.AN_ENCHANTED_GOLDEN_APPLE_A_DAY, CommonConfig.numericalSettings.anAppleADayCoolDowns)
            }
        }
    }

    private fun caseToAddEffect(
        tempNum: Int,
        player: Player
    ) {
        when (tempNum) {
            0 -> player.addEffect(MobEffectInstance(MobEffects.ABSORPTION, 2400, 3))
            1 -> player.addEffect(MobEffectInstance(MobEffects.REGENERATION, 400, 1))
            2 -> player.addEffect(MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000))
            3 -> player.addEffect(MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000))
        }
    }

    /**
     * 死亡朋克附魔效果
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun doDeathpunkEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return

        event.entity.safeClassCastAndHandle<Player> { player ->
            // 如果伤害来源是虚空伤害，则不触发死亡朋克附魔
            if (event.amount < player.health && event.source.`is`(DamageTypes.FELL_OUT_OF_WORLD)) return
            // 检查玩家是否装备了死亡朋克的胸甲
            if (player.isItemEnchanted(DeathPunkEnchantment, EquipmentSlot.CHEST)) {
                val solution = player.random.nextInt(4)
                val health = Mth.floor(player.health)
                val maxHealth = Mth.floor(player.maxHealth)
                var damageEnchantment = false
                // 随机情况
                when (solution) {
                    0 -> {
                        val saturationLevel = Mth.floor(player.foodData.saturationLevel)
                        var foodLevel = player.foodData.foodLevel + saturationLevel
                        if (foodLevel <= health) damageEnchantment = true
                        else {
                            if (foodLevel > maxHealth) foodLevel = maxHealth
                            player.health = foodLevel.toFloat()
                            player.foodData.foodLevel = health
                            player.foodData.addExhaustion(player.foodData.saturationLevel * 4)
                        }
                    }

                    1 -> {
                        var oxygenLevel = Mth.floor((player.airSupply / player.maxAirSupply / maxHealth).toFloat())
                        if (oxygenLevel <= health) damageEnchantment = true
                        else {
                            if (oxygenLevel > maxHealth) oxygenLevel = maxHealth
                            player.health = oxygenLevel.toFloat()
                            player.airSupply = health * (player.maxAirSupply / maxHealth)
                        }
                    }

                    2 -> {
                        val expPoint = player.totalExperience
                        val exchangeCost = Mth.floor(player.maxHealth - health) * 30
                        if (expPoint <= exchangeCost) damageEnchantment = true
                        else {
                            player.health = player.maxHealth
                            player.giveExperiencePoints(-exchangeCost)
                        }
                    }

                    3 -> damageEnchantment = true
                }
                // 如果damageEnchantment为true, 玩家生命值回满, 从胸甲中移除死亡朋克附魔
                if (damageEnchantment) {
                    player.health = player.maxHealth
                    val enchantments = EnchantmentHelper.getEnchantments(player.getItemBySlot(EquipmentSlot.CHEST))
                    enchantments -= DeathPunkEnchantment
                    EnchantmentHelper.setEnchantments(enchantments, player.getItemBySlot(EquipmentSlot.CHEST))
                }
                event.isCanceled = true
            }
        }
    }

    /**
     * 食髓知味
     */
    @SubscribeEvent
    fun doSavorTheTastedEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        val target = event.entity ?: return
        val attacker = event.source.entity ?: return

        if (attacker is Player) {
            val enchantmentLevel = attacker.getEnchantmentLevel(SavorTheTastedEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel <= 0) return
            val weaponNbt = attacker.mainHandItem.tag ?: return
            val targetEncodeId = target.encodeId ?: return
            val stringNBT = "savor_the_tasted_target"
            if (!weaponNbt.contains(stringNBT)) {
                weaponNbt.putString(stringNBT, targetEncodeId)
            } else {
                val recordedTarget = weaponNbt.getString(stringNBT) ?: return
                if (recordedTarget == targetEncodeId) {
                    event.amount += (target.random.nextInt(5) + enchantmentLevel * 4 - 1) * CommonConfig.numericalSettings.savorTheTastedEnchantment.toFloat()
                } else {
                    weaponNbt.putString(stringNBT, targetEncodeId)
                }
            }
            attacker.mainHandItem.tag = weaponNbt
        }
    }

    /**
     * 异常治疗
     */
    @SubscribeEvent
    fun doExoticHealerEnchantmentEvent(event: LivingHealEvent) {
        if (event.entity.level().isClientSide) return
        event.entity.safeClassCastAndHandle<Player> { player ->
            val enchantmentLevel = player.getArmorEnchantmentMaxLevel(ExoticHealerEnchantment)
            if (enchantmentLevel == 0) return
            val dice = player.random.nextInt(100)
            val modifier = 1 + (enchantmentLevel - 1) * 0.1f
            val duration = (600 * modifier).toInt()
            val source = DamageSourceBuilder.causeExtremeHatred(
                player.level().registryAccess()
            )
            when {
                dice < 33 -> event.isCanceled = true
                dice < 66 -> event.amount *= 2 * modifier
                dice < 91 -> player.addEffect(MobEffectInstance(MobEffects.DAMAGE_BOOST, duration))
                dice < 92 -> player.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration))
                dice < 93 -> player.addEffect(MobEffectInstance(MobEffects.REGENERATION, duration))
                dice < 94 -> player.addEffect(MobEffectInstance(MobEffects.INVISIBILITY, duration))
                dice < 95 -> {
                    player.hurt(source, event.amount * modifier)
                    event.isCanceled = true
                }
            }
        }
    }
}