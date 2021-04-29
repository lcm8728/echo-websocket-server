package me.lcm8728.echowebsocketserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchoWebsocketServerApplication

fun main(args: Array<String>) {
    runApplication<EchoWebsocketServerApplication>(*args)
}
