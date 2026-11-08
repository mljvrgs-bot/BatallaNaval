package com.example.navalprotocol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import com.example.navalprotocol.ui.theme.NavalTheme

/** Unica actividad: aloja el tema y (mas adelante) el grafo de navegacion. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavalTheme {
                // Caja a pantalla completa con el color de fondo del tema (azul oscuro).
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind { drawRect(androidx.compose.ui.graphics.Color(0xFF07111F)) },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Naval Protocol", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}