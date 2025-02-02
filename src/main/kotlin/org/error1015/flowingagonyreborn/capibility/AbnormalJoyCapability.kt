package org.error1015.flowingagonyreborn.capibility

class AbnormalJoyCapability(
    private var abnormalJoyPoint: Float = 0f
) {
    fun getPoint() = abnormalJoyPoint

    fun setPoint(level: Float) {
        abnormalJoyPoint = level
    }

    fun addPoint(point: Float) {
        if (abnormalJoyPoint + point > 100) abnormalJoyPoint = 100f
        else abnormalJoyPoint += point
    }

    fun decrease(point: Float) {
        if (abnormalJoyPoint - point < 0) abnormalJoyPoint = 0f
        else abnormalJoyPoint -= point
    }
}