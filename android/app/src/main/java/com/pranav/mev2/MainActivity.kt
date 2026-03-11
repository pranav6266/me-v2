package com.pranav.mev2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.pranav.mev2.data.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var message by remember { mutableStateOf("Loading...") }

            LaunchedEffect(Unit) {
                try {
                    val response = withContext(Dispatchers.IO) {
                        RetrofitClient.api.health().execute()
                    }

                    message = response.body() ?: "Error"

                } catch (e: Exception) {
                    message = e.message ?: "Connection failed"                }
            }

            Text(text = message)
        }
    }
}