package love.marblegate.flowingagonyreborn.addition

import love.marblegate.flowingagonyreborn.ID
import org.apache.logging.log4j.LogManager

object CuriosApiAddition {
    val logger = LogManager.getLogger()

    fun load() {
        logger.info("$ID: Curios API loaded")
    }
}