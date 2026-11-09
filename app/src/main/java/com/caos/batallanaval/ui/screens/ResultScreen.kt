package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.ui.components.GameResultCard

@Composable
fun ResultScreen(
    onPlayAgain: () -> Unit,
    onHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GameResultCard(winner = "Jugador 1")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onPlayAgain, modifier = Modifier.fillMaxWidth().height(56.dp)) {
            Text("JUGAR DE NUEVO")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = onHome, modifier = Modifier.fillMaxWidth().height(56.dp)) {
            Text("VOLVER AL INICIO")
        }
    }
}