package love.marblegate.flowingagonyreborn.event.enchantment

import love.marblegate.flowingagonyreborn.config.CommonConfig
import love.marblegate.flowingagonyreborn.damagesource.DamageSourceBuilder
import love.marblegate.flowingagonyreborn.damagesource.ModDamageTypes
import love.marblegate.flowingagonyreborn.effect.ModEffects
import love.marblegate.flowingagonyreborn.enchantment.madeofmadness.*
import love.marblegate.flowingagonyreborn.util.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.Containers
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.boss.enderdragon.EnderDragon
import net.minecraft.world.entity.monster.Creeper
import net.minecraft.world.entity.monster.Skeleton
import net.minecraft.world.entity.monster.WitherSkeleton
import net.minecraft.world.entity.monster.Zombie
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.DiggerItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.LootParams
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.minecraft.world.level.storage.loot.parameters.LootContextParams
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import net.minecraftforge.event.entity.living.LivingDamageEvent
import net.minecraftforge.event.entity.living.LivingDeathEvent
import net.minecraftforge.event.level.BlockEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import kotlin.math.roundToInt


@Mod.EventBusSubscriber
object MadeOfMadnessEnchantmentEventHandler {
    @SubscribeEvent
    fun onAgonyScreamerEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(AgonyScreamerEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            event.entity.addEffect(MobEffectInstance(ModEffects.AGONY_RESONANCE, 140 + 20 * enchantmentLevel, enchantmentLevel))
        }
    }

    @SubscribeEvent
    fun onInsanePoetEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(InsanePoetEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            event.entity.addEffect(MobEffectInstance(ModEffects.LISTEN_TO_ME_SINGING, 40 * enchantmentLevel, enchantmentLevel - 1))
            player.addEffect(MobEffectInstance(ModEffects.INSANE_POET_ENCHANTMENT_ACTIVE, enchantmentLevel * 40).setImplicit)
            event.amount *= CommonConfig.generalSettings.insanePoetDamageReduction.toFloat()
        }
    }

    @SubscribeEvent
    fun onPaperBrainEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        val player = event.source.entity ?: return
        if (player is Player) {
            val enchantmentLevel = player.getEnchantmentLevel(PaperBrainEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel <= 0) return
            event.entity.addEffect(
                MobEffectInstance(
                    ModEffects.PAPER_BRAIN_ENCHANTMENT_ACTIVE, enchantmentLevel * 40 + 20, enchantmentLevel - 1
                ).setImplicit
            )
            event.amount *= (1.0 - CommonConfig.generalSettings.paperBrainDamageReduction).toFloat()
        }
    }

    @SubscribeEvent
    fun onShockTherapyEnchantmentEvent(event: LivingDamageEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.entity is Player) {
            val player = event.source.entity as Player
            val enchantmentLevel = player.getEnchantmentLevel(ShockTherapyEnchantment, EquipmentSlot.MAINHAND)
            if (enchantmentLevel == 0) return
            event.entity.addEffect(
                MobEffectInstance(
                    ModEffects.SHOCK_THERAPY_ENCHANTMENT_ACTIVE, enchantmentLevel * 40 + 20, enchantmentLevel - 1
                ).setImplicit
            )
            event.amount *= (1.0 - CommonConfig.generalSettings.shockTherapyDamageReduction).toFloat()
        }
    }

    @SubscribeEvent
    fun onCuttingWatermelonDreamEnchantmentEventDealDamage(event: BlockEvent.BreakEvent) {
        if (event.player.level().isClientSide) return
        val cuttingWaterMelonDreamDamageSource = DamageSourceBuilder.causeCuttingWaterMelonDream(event.player)
        if (event.state.block == Blocks.MELON) {
            if (event.player.isItemEnchanted(CuttingWatermelonDreamEnchantment, EquipmentSlot.MAINHAND)) {
                val targets = event.player.getTargetsExceptOneself(12f, 2f) { entity -> entity.isHostile(false) }
                if (targets.isEmpty()) return
                val silkLevel = event.player.getEnchantmentLevel(Enchantments.SILK_TOUCH, EquipmentSlot.MAINHAND)
                val unBreakingLevel = event.player.getEnchantmentLevel(Enchantments.UNBREAKING, EquipmentSlot.MAINHAND)
                var damage = 0f
                if (event.player.getItemBySlot(EquipmentSlot.MAINHAND).item is DiggerItem) {
                    damage += (event.player.getItemBySlot(EquipmentSlot.MAINHAND).item as DiggerItem).attackDamage
                }
                if (silkLevel == 1) damage *= 0.5f
                damage *= if (event.player.level().dayTime * 24000 > 13000) (4 + event.player.random.nextDouble() * 2).toFloat() else 2 + event.player.random
                    .nextDouble()
                    .toFloat()
                targets.forEach { target ->
                    target.hurt(cuttingWaterMelonDreamDamageSource, damage * CommonConfig.numericalSettings.cuttingWatermelonDream.toFloat())
                }
                if (unBreakingLevel == 0) return
                val damageAppliedToItem = if (unBreakingLevel == 3) 3 else 4
                event.player
                    .getItemBySlot(EquipmentSlot.MAINHAND)
                    .hurtAndBreak(damageAppliedToItem, event.player) { }
            }
        }
    }

    @SubscribeEvent
    fun onCuttingWatermelonDreamEnchantmentEventDropHeadAndExtraLoot(event: LivingDeathEvent) {
        if (event.entity.level().isClientSide) return
        if (event.source.`is`(ModDamageTypes.cutting_watermelon_dream) && event.source.entity is Player && event.entity.supportHeadDrop()) {
            val player = event.source.entity as Player
            val entity = event.entity ?: return
            if (player.isItemEnchanted(CuttingWatermelonDreamEnchantment, EquipmentSlot.MAINHAND)) {
                val silkLevel = player.getEnchantmentLevel(Enchantments.SILK_TOUCH, EquipmentSlot.MAINHAND)
                val fortuneLevel = player.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE, EquipmentSlot.MAINHAND)
                if (silkLevel > 0) {
                    val dropHeadRate = 0.025 + 0.01 * fortuneLevel
                    if (Math.random() < dropHeadRate) {
                        when (entity) {
                            is Zombie -> Containers.dropItemStack(
                                entity.level(), entity.x, entity.y, entity.z, Items.ZOMBIE_HEAD.defaultInstance
                            )

                            is Skeleton -> Containers.dropItemStack(
                                entity.level(), entity.x, entity.y, entity.z, Items.SKELETON_SKULL.defaultInstance
                            )

                            is Creeper -> Containers.dropItemStack(
                                entity.level(), entity.x, entity.y, entity.z, Items.CREEPER_HEAD.defaultInstance
                            )

                            is WitherSkeleton -> Containers.dropItemStack(
                                entity.level(), entity.x, entity.y, entity.z, Items.WITHER_SKELETON_SKULL.defaultInstance
                            )

                            is EnderDragon -> Containers.dropItemStack(
                                entity.level(), entity.x, entity.y, entity.z, Items.DRAGON_HEAD.defaultInstance
                            )
                        }
                    }
                }
                if (fortuneLevel > 0) dropLoot(
                    event.entity, player, player
                        .damageSources()
                        .playerAttack(player), fortuneLevel
                )
            }
        }
    }

    private fun dropLoot(
        entity: LivingEntity,
        player: Player,
        source: DamageSource,
        lootLevel: Int
    ) {
        val resourceLocation: ResourceLocation = entity.lootTable
        val lootTable = entity.level().server?.lootData?.getLootTable(resourceLocation) ?: return
        val context = getLootContextBuilder(entity, player, source).create(resourceLocation)
        lootTable.getRandomItems(context) {
            entity.spawnAtLocation(recalculateLootByLootingLevel(it, context, lootLevel))
        }
    }

    private fun getLootContextBuilder(
        entity: LivingEntity,
        player: Player,
        source: DamageSource
    ): LootContext.Builder {
        val serverLevel = entity.level() as ServerLevel
        val paramsBuilder = LootParams
            .Builder(serverLevel)
            .withParameter(LootContextParams.THIS_ENTITY, entity)
            .withParameter(LootContextParams.ORIGIN, entity.position())
            .withParameter(LootContextParams.DAMAGE_SOURCE, source)
            .withOptionalParameter(LootContextParams.KILLER_ENTITY, source.entity)
            .withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, source.directEntity)
            .withParameter(LootContextParams.LAST_DAMAGE_PLAYER, player)
            .withLuck(player.luck)
            .create(LootContextParamSets.ENTITY)

        return LootContext.Builder(paramsBuilder)
    }

    fun recalculateLootByLootingLevel(
        stack: ItemStack,
        context: LootContext,
        lootLevel: Int
    ): ItemStack {
        val f = lootLevel.toFloat() * UniformGenerator
            .between(0f, 1f)
            .getFloat(context)
        stack.grow(f.roundToInt())
        return stack
    }
}