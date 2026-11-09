package com.example.navalprotocol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.navalprotocol.ui.screens.LoginScreen
import com.example.navalprotocol.ui.screens.RegisterScreen
import com.example.navalprotocol.ui.theme.NavalTheme

/** Unica actividad: aloja el tema y (mas adelante) el grafo de navegacion. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavalTheme {
                // PROVISIONAL: alterna login/registro hasta tener el NavGraph (Paso 9).
                var showRegister by remember { mutableStateOf(false) }
                if (showRegister) {
                    RegisterScreen(onSuccess = {}, onGoLogin = { showRegister = false })
                } else {
                    LoginScreen(onSuccess = {}, onGoRegister = { showRegister = true })
                }
            }
        }
    }
}