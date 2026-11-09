package com.example.navalprotocol.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navalprotocol.ui.components.NavalTopBar

/** Una fila del ranking: puesto, nombre y puntaje. */
private data class LeaderboardEntry(val rank: Int, val name: String, val score: Int)

// Nombre del jugador actual; su fila se resalta. Luego vendra de la sesion.
private const val ME = "Capitan Jack"

// Datos de maqueta: ranking global y del tablero diario con semilla.
private val globalBoard = listOf(
    LeaderboardEntry(1, "AlmiranteNova", 9800),
    LeaderboardEntry(2, "KrakenHunter", 9150),
    LeaderboardEntry(3, "Almirante Sol", 8700),
    LeaderboardEntry(4, ME, 4820),
    LeaderboardEntry(5, "PirataByte", 4100),
    LeaderboardEntry(6, "Timon", 3300)
)
private val dailyBoard = listOf(
    LeaderboardEntry(1, "Almirante Sol", 2400),
    LeaderboardEntry(2, "KrakenHunter", 2250),
    LeaderboardEntry(3, ME, 1900),
    LeaderboardEntry(4, "Timon", 1500)
)

/** Tabla de clasificacion con dos pestanas: Global y Diario. */
@Composable
fun LeaderboardScreen(onBack: () -> Unit) {
    // Pestana seleccionada: 0 = Global, 1 = Diario.
    var tab by remember { mutableIntStateOf(0) }
    val entries = if (tab == 0) globalBoard else dailyBoard

    Scaffold(topBar = { NavalTopBar("Ranking", onBack) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            TabRow(selectedTabIndex = tab) {
                Tab(selected = tab == 0, onClick = { tab = 0 }, text = { Text("Global") })
                Tab(selected = tab == 1, onClick = { tab = 1 }, text = { Text("Diario") })
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(entries, key = { it.rank }) { LeaderboardRow(it) }
            }
        }
    }
}

@Composable
private fun LeaderboardRow(entry: LeaderboardEntry) {
    val isMe = entry.name == ME
    val accent = MaterialTheme.colorScheme.primary
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        // La fila del jugador actual se distingue con otro fondo.
        color = if (isMe) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                // Los tres primeros puestos van en color de acento.
                Text("#${entry.rank}", color = if (entry.rank <= 3) accent else MaterialTheme.colorScheme.onSurfaceVariant)
                Text(entry.name, color = if (isMe) accent else MaterialTheme.colorScheme.onSurface)
            }
            Text("${entry.score} pts")
        }
    }
}