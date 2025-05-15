package love.marblegate.flowingagonyreborn.util

import net.minecraftforge.event.TickEvent
import net.minecraftforge.event.entity.EntityEvent

/**
 * 把一个对象转换成另一个对象，当转换成功时执行函数
 * 失败时弹出警告信息
 */
inline fun <reified T> Any?.safeClassCastAndHandle(block: (T) -> Unit) {
    if (this != null) {
        if (this is T) {
            block(this)
        }
    }
}

/**
 * 处理客户端实体事件
 */
inline fun <E : EntityEvent> E.handleClient(clientBLock: () -> Unit) {
    if (this.entity.level().isClientSide) {
        clientBLock()
    }
}

/**
 * 处理服务端实体事件
 */
inline fun <E : EntityEvent> E.handleServer(serverBlock: E.() -> Unit) {
    if (!this.entity.level().isClientSide) {
        serverBlock()
    }
}

inline fun TickEvent.PlayerTickEvent.handleClient(serverBlock: TickEvent.PlayerTickEvent.() -> Unit) {
    if (!this.player.level().isClientSide) {
        serverBlock()
    }
}

inline fun TickEvent.PlayerTickEvent.handleServer(clientBlock: TickEvent.PlayerTickEvent.() -> Unit) {
    if (this.player.level().isClientSide) {
        clientBlock()
    }
}