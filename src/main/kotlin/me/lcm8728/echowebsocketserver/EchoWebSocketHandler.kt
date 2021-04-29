package me.lcm8728.echowebsocketserver

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.AbstractWebSocketHandler
import java.util.logging.Logger

class EchoWebSocketHandler : AbstractWebSocketHandler() {
    private val logger = Logger.getLogger(this::class.java.name)

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        session.sendMessage(message)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        logger.info("connected: ${session.remoteAddress}")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        logger.info("closed: ${session.remoteAddress}")
    }
}