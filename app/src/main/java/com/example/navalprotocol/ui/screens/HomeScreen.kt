package com.example.navalprotocol.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Inicio: iniciar partida, ver como jugar y acceder a cuenta y comunidad. */
@Composable
fun HomeScreen(
    onStart: () -> Unit,
    onHowToPlay: () -> Unit,
    onProfile: () -> Unit,
    onLeaderboard: () -> Unit,
    onSettings: () -> Unit,
    onNotifications: () -> Unit
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("NAVAL", style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.primary)
            Text("PROTOCOL", style = MaterialTheme.typography.displaySmall)
            Text(
                "Batalla naval roguelike",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Button(onClick = onStart, modifier = Modifier.fillMaxWidth().padding(top = 24.dp)) { Text("Iniciar") }
            OutlinedButton(onClick = onHowToPlay, modifier = Modifier.fillMaxWidth()) { Text("Como jugar") }

            // Accesos a cuenta y comunidad.
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onProfile, modifier = Modifier.weight(1f)) { Text("Perfil") }
                TextButton(onClick = onLeaderboard, modifier = Modifier.weight(1f)) { Text("Ranking") }
                TextButton(onClick = onSettings, modifier = Modifier.weight(1f)) { Text("Ajustes") }
            }
            TextButton(onClick = onNotifications) { Text("Notificaciones") }
        }
    }
}