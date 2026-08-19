package love.marblegate.flowingagonyreborn.capability

import java.util.*
import kotlin.math.max

class CoolDown(
    var coolDownMap: Map<CoolDownType, Int> = EnumMap(CoolDownType::class.java)
) {
    init {
        coolDownMap = EnumMap(CoolDownType::class.java)
        for (values in CoolDownType.entries) {
            (coolDownMap as EnumMap<CoolDownType, Int>)[values] = 0
        }
    }

    fun get(cooldownType: CoolDownType) = coolDownMap[cooldownType] ?: 0

    fun isReady(cooldownType: CoolDownType) = (coolDownMap[cooldownType] ?: 0) < 1

    fun set(
        cooldownType: CoolDownType, cooldownTick: Int
    ) {
        coolDownMap + (cooldownType to max(0, cooldownTick))
    }

    fun decrease(cooldownType: CoolDownType) {
        if (!isReady(cooldownType)) coolDownMap + (cooldownType to (coolDownMap[cooldownType]?.minus(1) ?: 0))
    }

    enum class CoolDownType {
        AN_ENCHANTED_GOLDEN_APPLE_A_DAY,
        MORIRS_DEATHWISH_DEATHMENDING
    }
}