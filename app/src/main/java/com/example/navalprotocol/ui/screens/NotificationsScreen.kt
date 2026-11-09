package com.example.navalprotocol.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navalprotocol.ui.components.NavalTopBar
import com.example.navalprotocol.ui.components.OptionCard

/** Una notificacion de la app: titulo, texto y si ya fue leida. */
private data class AppNotification(val title: String, val body: String, val read: Boolean = false)

/** Centro de notificaciones dentro de la app. Tocar una la marca como leida. */
@Composable
fun NotificationsScreen(onBack: () -> Unit) {
    // Lista de maqueta; luego vendra del servicio de notificaciones.
    // mutableStateListOf hace que la pantalla se redibuje al cambiar un elemento.
    val notifications = remember {
        mutableStateListOf(
            AppNotification("Invitacion recibida", "Almirante Sol te reta a una partida clasica."),
            AppNotification("Nuevo tablero diario", "Ya puedes jugar el tablero de hoy."),
            AppNotification("Subiste en el ranking", "Ahora estas en el puesto #4.", read = true)
        )
    }

    Scaffold(topBar = { NavalTopBar("Notificaciones", onBack) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(onClick = {
                // Se reemplaza cada elemento por una copia marcada como leida.
                notifications.indices.forEach { notifications[it] = notifications[it].copy(read = true) }
            }) { Text("Marcar todas como leidas") }

            if (notifications.isEmpty()) {
                Text("No tienes notificaciones.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(notifications) { index, n ->
                    // Las no leidas se resaltan con el borde de acento (selected = true).
                    OptionCard(
                        title = n.title,
                        subtitle = n.body,
                        modifier = Modifier.fillMaxWidth(),
                        selected = !n.read,
                        onClick = { notifications[index] = n.copy(read = true) }
                    )
                }
            }
        }
    }
}