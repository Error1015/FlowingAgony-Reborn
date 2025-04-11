package love.marblegate.flowingagonyreborn.util.proxy

import love.marblegate.flowingagonyreborn.network.Networking
import net.minecraftforge.network.PacketDistributor

/**
 * 在INSTANCE初始化的情况下进行发包
 */
fun <MSG> Networking.safeSend(target: PacketDistributor.PacketTarget, message: MSG) {
    if (this.isInstanceInitialized()) {
        INSTANCE.send<MSG>(target, message)
    }
}