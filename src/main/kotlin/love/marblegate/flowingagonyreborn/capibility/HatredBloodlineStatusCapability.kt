package love.marblegate.flowingagonyreborn.capibility

class HatredBloodlineStatusCapability(
    private var hatredBloodlineLevel: Int = 0
) {
    fun getActiveLevel() = hatredBloodlineLevel

    fun setActiveLevel(level: Int) {
        hatredBloodlineLevel = level
    }
}