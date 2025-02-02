package org.error1015.flowingagonyreborn.capibility

class HatredBloodlineStatusCapability(
    private var hatredBloodlineLevel: Int = 0
) {
    fun getActiveLevel() = hatredBloodlineLevel

    fun setActiveLevel(level: Int) {
        hatredBloodlineLevel = level
    }
}