package com.example.navalprotocol.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navalprotocol.ui.components.NavalTopBar
import com.example.navalprotocol.ui.components.OptionCard

/**
 * Ajustes: idioma, sonido, notificaciones y cierre de sesion.
 * TODO: aplicar el idioma de verdad (recursos strings.xml por idioma) y guardar las
 * preferencias en Room/DataStore. Por ahora solo cambia el estado visual.
 */
@Composable
fun SettingsScreen(onBack: () -> Unit, onSignOut: () -> Unit) {
    // rememberSaveable conserva los valores si se gira la pantalla.
    var language by rememberSaveable { mutableStateOf("es") }
    var notifications by rememberSaveable { mutableStateOf(true) }
    var sound by rememberSaveable { mutableStateOf(true) }

    Scaffold(topBar = { NavalTopBar("Ajustes", onBack) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Idioma", style = MaterialTheme.typography.titleSmall)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // La tarjeta seleccionada se resalta con el borde de acento.
                OptionCard("Espanol", "ES", Modifier.weight(1f), selected = language == "es", onClick = { language = "es" })
                OptionCard("English", "EN", Modifier.weight(1f), selected = language == "en", onClick = { language = "en" })
            }

            SwitchRow("Notificaciones en la app", notifications) { notifications = it }
            SwitchRow("Sonido", sound) { sound = it }

            OutlinedButton(
                onClick = onSignOut,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)
            ) { Text("Cerrar sesion") }
        }
    }
}

/** Fila con una etiqueta a la izquierda y un interruptor a la derecha. */
@Composable
private fun SwitchRow(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        Switch(checked = checked, onCheckedChange = onChange)
    }
}