package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewLifeScreen(
    recoveredShipName: String,
    onAcceptMechanic: () -> Unit,
    onDecline: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1B4B))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("¡MECÁNICA ACTIVADA!", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA78BFA))
        Text("NUEVA VIDA", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF312E81)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Tu último barco ha sido destruido, pero puedes desplegar la habilidad especial para reiniciar el tablero oponente y reubicar tu:", color = Color(0xFFE0E7FF), fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Barco a recuperar: $recoveredShipName", fontWeight = FontWeight.Bold, color = Color(0xFFFDE047))
            }
        }

        Button(
            onClick = onAcceptMechanic,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("REUBICAR BARCO Y CONTINUAR", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = onDecline) {
            Text("Rendirse y finalizar", color = Color(0xFF9CA3AF))
        }
    }
}