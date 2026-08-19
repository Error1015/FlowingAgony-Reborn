package love.marblegate.flowingagonyreborn.capability

class HatredBloodlineStatusCapability(
    private var hatredBloodlineLevel: Int = 0
) {
    fun getActiveLevel() = hatredBloodlineLevel

    fun setActiveLevel(level: Int) {
        hatredBloodlineLevel = level
    }
}