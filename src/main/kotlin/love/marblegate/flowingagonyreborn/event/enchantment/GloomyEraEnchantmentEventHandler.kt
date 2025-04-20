package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.Config
import love.marblegate.flowingagonyreborn.enchantment.ModEnchantments
import love.marblegate.flowingagonyreborn.util.*
import net.minecraft.util.Mth
import net.minecraft.util.RandomSource
import net.minecraft.world.Containers
import net.minecraft.world.InteractionHand
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.ai.gossip.GossipType
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.monster.Witch
import net.minecraft.world.entity.monster.ZombieVillager
import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.item.trading.MerchantOffer
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.event.entity.living.LivingFallEvent
import net.minecraftforge.event.entity.living.MobEffectEvent
import net.minecraftforge.event.level.BlockEvent
import net.minecraftforge.eventbus.api.Event
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod


@Mod.EventBusSubscriber
object GloomyEraEnchantmentEventHandler {
    @SubscribeEvent
    fun doRegularCustomerProgramEnchantmentEvent(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player && (event.entity is ZombieVillager || event.entity is Witch)) {
            val player = event.source.entity as Player
            if (player.isItemEnchanted(ModEnchantments.RegularCustomerProgram, EquipmentSlot.MAINHAND)) {
                val targets = event.entity.getTargetsExceptOneself(12f, 2f) { entity -> entity is Villager }
                if (targets.isEmpty()) return
                targets.forEach { (it as Villager).gossips.add(player.uuid, GossipType.MINOR_POSITIVE, 1) }
            }
        }
    }

    @SubscribeEvent
    fun doCleansingBeforeUsingEnchantmentEvent(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player && event.entity is Villager) {
            val villager = event.entity as Villager
            val mainHandItem = villager.getItemInHand(InteractionHand.MAIN_HAND) ?: return
            mainHandItem.setRepairCost(0)
            if (mainHandItem.isDamageableItem) {
                mainHandItem.damageValue -= 10
            }
        }
    }

    @SubscribeEvent
    fun doComeBackAtDuskEnchantmentEvent(event: TickEvent.PlayerTickEvent) {
        if (event.player.level().isClientSide || event.phase != TickEvent.Phase.START) return
        if (event.player.armorHasEnchantment(ModEnchantments.DirtyMoney)) {
            if (event.player.level().dayTime % 24000 >= 10999 && event.player.level().dayTime % 24000 < 13501 && event.player.armorHasEnchantment(
                        ModEnchantments.ComeBackAtDusk
                    )) {
                if (!event.player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
                    val temp = Math.random()
                    val amplifier = when {
                        temp < 0.9 -> 0
                        temp < 0.95 -> 1
                        temp < 0.98 -> 2
                        temp < 0.99 -> 3
                        else -> 4
                    }
                    event.player.addEffect(MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300, amplifier))
                }
            }
        }
    }

    @SubscribeEvent
    fun doDirtyMoneyEnchantmentEventPreventHOTVEffect(event: MobEffectEvent.Applicable) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player && event.effectInstance.effect == MobEffects.HERO_OF_THE_VILLAGE && event.entity.armorHasEnchantment(
                    ModEnchantments.DirtyMoney
                )) {
            event.result = Event.Result.DENY
        }
    }

    @SubscribeEvent
    fun doDirtyMoneyEnchantmentEventDropGoods(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Villager && event.source.entity is Player) {
            val player = event.source.entity as Player
            val maxLevel = player.getArmorEnchantmentMaxLevel(ModEnchantments.DirtyMoney)
            if (maxLevel == 0) return
            if (Math.random() < 0.1 * maxLevel) {
                Containers.dropItemStack(
                    event.entity.level(), event.entity.x, event.entity.y + 2, event.entity.z, Items.EMERALD.defaultInstance
                )
            }
            if (Math.random() < 0.02 * maxLevel) {
                Containers.dropItemStack(
                    event.entity.level(), event.entity.x, event.entity.y + 2, event.entity.z, Items.GOLD_INGOT.defaultInstance
                )
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun doPilferageCreedEnchantmentEvent(event: LivingFallEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Player) {
            val player = event.entity as Player
            if (player.isItemEnchanted(ModEnchantments.PilferageCreed, EquipmentSlot.FEET)) {
                if (event.distance >= 5.0f) {
                    val targets = player.getTargetsExceptOneself(5f, 1f) { it is Villager }
                    if (targets.isEmpty()) return
                    targets.forEach {
                        val offers = (it as Villager).offers
                        val outcome = rollDiceForPilferage(player.boots, it, offers, event.entity.random, event.distance.toDouble())
                        outcome.forEach { stack ->
                            it.level().addFreshEntity(ItemEntity(it.level(), it.x, it.y, it.z, stack))
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun doCarefullyIdentifiedEnchantmentEvent(event: BlockEvent.BreakEvent) {
        if (event.player.level().isClientSide) return
        val isStone = event.state.block == Blocks.STONE
        if (isStone || event.state.block == Blocks.DEEPSLATE) {
            val enchantmentLevel = event.player.getEnchantmentLevel(ModEnchantments.CarefullyIdentified, EquipmentSlot.MAINHAND)
            val silkTouchLevel = event.player.getEnchantmentLevel(Enchantments.SILK_TOUCH, EquipmentSlot.MAINHAND)
            val forTuneLevel = event.player.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE, EquipmentSlot.MAINHAND)
            if (enchantmentLevel <= 0) return
            if (Math.random() < 0.01) {
                val coal = if (silkTouchLevel != 0) Items.COAL.defaultInstance else if (isStone) Items.COAL_ORE.defaultInstance else Items.DEEPSLATE_COAL_ORE.defaultInstance
                if (forTuneLevel >= 1) {
                    if (Math.random() < 0.5) coal.grow(forTuneLevel)
                }
                Containers.dropItemStack(event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), coal)
            }
            if (enchantmentLevel > 1) {
                if (Math.random() < 0.005) {
                    val iron = if (silkTouchLevel != 0) Items.RAW_IRON.defaultInstance else if (isStone) Items.IRON_ORE.defaultInstance else Items.DEEPSLATE_IRON_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) iron.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), iron
                    )
                }
                if (Math.random() < 0.005) {
                    val copper = if (silkTouchLevel != 0) Items.RAW_COPPER.defaultInstance else if (isStone) Items.COPPER_ORE.defaultInstance else Items.DEEPSLATE_COPPER_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) copper.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), copper
                    )
                }
            }

            if (enchantmentLevel > 2) {
                if (Math.random() < 0.001) {
                    val gold = if (silkTouchLevel != 0) Items.RAW_GOLD.defaultInstance else if (isStone) Items.GOLD_ORE.defaultInstance else Items.DEEPSLATE_GOLD_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) gold.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), gold
                    )
                }
                if (Math.random() < 0.002) {
                    val redStone = if (silkTouchLevel != 0) Items.REDSTONE.defaultInstance else if (isStone) Items.REDSTONE_ORE.defaultInstance else Items.DEEPSLATE_REDSTONE_ORE.defaultInstance
                    if (forTuneLevel >= 1) if (Math.random() < 0.5) redStone.grow(forTuneLevel)
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), redStone
                    )
                }
            }

            if (enchantmentLevel > 3) {
                if (Math.random() < 0.001) {
                    val lapis = if (silkTouchLevel != 0) Items.LAPIS_LAZULI.defaultInstance else if (isStone) Items.LAPIS_ORE.defaultInstance else Items.DEEPSLATE_LAPIS_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) lapis.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), lapis
                    )
                }
            }

            if (enchantmentLevel > 4) {
                if (Math.random() < 0.001) {
                    val emerald = if (silkTouchLevel != 0) Items.EMERALD.defaultInstance else if (isStone) Items.EMERALD_ORE.defaultInstance else Items.DEEPSLATE_EMERALD_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) emerald.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), emerald
                    )
                }

                if (Math.random() < 0.001) {
                    val diamond = if (silkTouchLevel != 0) Items.DIAMOND.defaultInstance else if (isStone) Items.DIAMOND_ORE.defaultInstance else Items.DEEPSLATE_DIAMOND_ORE.defaultInstance
                    if (forTuneLevel >= 1) {
                        if (Math.random() < 0.5) diamond.grow(forTuneLevel)
                    }
                    Containers.dropItemStack(
                        event.level as Level, event.pos.x.toDouble(), event.pos.y.toDouble(), event.pos.z.toDouble(), diamond
                    )
                }
            }
        }
    }

    @SubscribeEvent
    fun doNimbleFingerEnchantmentEvent(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.entity is Mob && event.entity !is Player && event.source.directEntity is Player) {
            val player = event.source.directEntity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ModEnchantments.NimbleFinger, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            val itemStacks = mutableListOf<ItemStack>()

            event.entity.armorSlots.forEach { stack ->
                if (stack.isEmpty) return
                itemStacks += stack
            }

            itemStacks.forEach { stack ->
                if (event.entity.random.nextDouble() < 0.5 + 0.1 * enchantmentLevel) {
                    Containers.dropItemStack(
                        event.entity.level(), event.entity.x, event.entity.y, event.entity.z, stack
                    )
                }
            }
        }
    }

    fun rollDiceForPilferage(
        armorFeet: ItemStack, villager: Villager, offers: List<MerchantOffer>, random: RandomSource, fallingHeight: Double
    ): List<ItemStack> {
        var extraLuck = Mth.floor(fallingHeight)
        extraLuck = minOf(extraLuck, 15)
        extraLuck -= 5
        val list = mutableListOf<ItemStack>()
        var success = false
        if (random.nextInt(100) < 30 + 5 * extraLuck) {
            val temp = random.nextInt(offers.size)
            list += offers[temp].result.copy()
            success = true
        }

        if (random.nextInt(100) < 15 + 2.5f * extraLuck && offers.size > 3) {
            val temp = random.nextInt(offers.size)
            list += offers[temp].result.copy()
            success = true
        }

        if (random.nextInt(100) < 5 + 1.5f * extraLuck && offers.size > 5) {
            val temp = random.nextInt(offers.size)
            list += offers[temp].result.copy()
            success = true
        }

        if (random.nextInt(100) < 30 + 5 * extraLuck) {
            if (!Config.generalSettings.villagerSafeMode.get()) villager.hurt(villager.damageSources().generic(), 1 + extraLuck * 0.5f)
        }

        if (success) if (armorFeet != ItemStack.EMPTY) armorFeet.hurtAndBreak(30, villager) { }

        return list
    }

}