package com.example.navalprotocol.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navalprotocol.ui.components.NavalTopBar
import com.example.navalprotocol.ui.components.OptionCard

// Datos de maqueta. Luego vendran de Room (local) y del servicio de estadisticas (online).
private const val MOCK_NAME = "Capitan Jack"

// Estadisticas como pares (etiqueta, valor).
private val stats = listOf(
    "Partidas" to "24",
    "Victorias" to "15",
    "Efectividad" to "62%",
    "Mejor puntaje" to "4820"
)

// Ultimas partidas como pares (titulo, detalle).
private val recentRuns = listOf(
    "Run #24" to "Victoria - 4820 pts",
    "Run #23" to "Derrota - 1930 pts",
    "Run #22" to "Victoria - 3560 pts"
)

/** Perfil del jugador: avatar, estadisticas generales y ultimas partidas. */
@Composable
fun ProfileScreen(onBack: () -> Unit, onSettings: () -> Unit) {
    Scaffold(topBar = { NavalTopBar("Perfil", onBack) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar circular con la inicial del nombre (la letra despues del espacio).
            Box(
                modifier = Modifier
                    .size(84.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = MOCK_NAME.substringAfter(" ").first().uppercase(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Text(MOCK_NAME, style = MaterialTheme.typography.titleLarge)

            // Estadisticas en cuadricula de 2 columnas: se agrupan de a dos por fila.
            stats.chunked(2).forEach { pair ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    pair.forEach { (label, value) ->
                        OptionCard(title = value, subtitle = label, modifier = Modifier.weight(1f), onClick = {})
                    }
                }
            }

            Text(
                "Ultimas partidas",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
            recentRuns.forEach { (title, detail) ->
                OptionCard(title = title, subtitle = detail, modifier = Modifier.fillMaxWidth(), onClick = {})
            }

            OptionCard(
                title = "Ajustes",
                subtitle = "Idioma, sonido y notificaciones",
                modifier = Modifier.fillMaxWidth(),
                onClick = onSettings
            )
        }
    }
}