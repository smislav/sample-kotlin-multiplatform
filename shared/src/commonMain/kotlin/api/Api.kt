package api

import MessageHandler
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class Api {
    private val client = HttpClient()

    suspend fun getElephants(messageHandler: MessageHandler) {
        val response = client.get<String> { url("https://elephant-api.herokuapp.com/elephants") }
        messageHandler.handleMessage(response)
    }
}