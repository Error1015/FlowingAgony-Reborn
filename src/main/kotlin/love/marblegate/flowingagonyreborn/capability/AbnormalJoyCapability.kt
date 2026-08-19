package love.marblegate.flowingagonyreborn.capability

class AbnormalJoyCapability(
    var abnormalJoyPoint: Float = 0f
) {
    fun addPoint(point: Float) {
        if (abnormalJoyPoint + point > 100) {
            abnormalJoyPoint = 100f
        } else {
            abnormalJoyPoint += point
        }
    }

    fun decrease(point: Float) {
        if (abnormalJoyPoint - point < 0) {
            abnormalJoyPoint = 0f
        } else {
            abnormalJoyPoint -= point
        }
    }
}