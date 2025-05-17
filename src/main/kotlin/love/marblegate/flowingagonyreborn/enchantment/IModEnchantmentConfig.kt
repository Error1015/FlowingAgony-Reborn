package love.marblegate.flowingagonyreborn.enchantment


interface IModEnchantmentConfig {
    fun isTradableConfig(): Boolean

    fun isDiscoverableConfig(): Boolean

    fun canApplyAtEnchantingTableConfig(): Boolean

    fun isTreasureOnlyConfig(): Boolean
}