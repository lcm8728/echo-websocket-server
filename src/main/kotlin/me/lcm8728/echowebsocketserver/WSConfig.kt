package me.lcm8728.echowebsocketserver

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean

@Configuration
@EnableWebSocket
class WSConfig(
    @Value("\${websocket.max-text-message-buffer-size}")
    private val binaryMessageBuffer: Int,
    @Value("\${websocket.max-binary-message-buffer-size}")
    private val textMessageBuffer: Int,
    @Value("\${websocket.max-session-idle-timeout}")
    private val timeout: Long,
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(echoWebSocketHandler(), "/ws").setAllowedOrigins("*")
    }

    @Bean
    fun echoWebSocketHandler(): EchoWebSocketHandler {
        return EchoWebSocketHandler()
    }

    @Bean
    fun createWebSocketContainer(): ServletServerContainerFactoryBean {
        return ServletServerContainerFactoryBean()
            .apply {
                setMaxTextMessageBufferSize(textMessageBuffer)
                setMaxBinaryMessageBufferSize(binaryMessageBuffer)
                setMaxSessionIdleTimeout(timeout)
            }
    }

}