package agency.decode.kmp

import MessageHandler
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import api.Api
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadElephants()
    }

    private fun loadElephants() {
        val api = Api()

        scope.launch {
            withContext(Dispatchers.IO) {
                api.getElephants(object : MessageHandler {
                    override fun handleMessage(message: String) {
                        Log.i("MESSAGE:", message)
                    }
                })
            }
        }
    }
}
