package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onStartGame: () -> Unit,
    onHowToPlay: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "NAVAL PROTOCOL",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF38BDF8),
            letterSpacing = 2.sp
        )
        Text(
            text = "Tactical Roguelike Combat",
            fontSize = 14.sp,
            color = Color(0xFF94A3B8),
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Button(
            onClick = onStartGame,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("INICIAR PARTIDA", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onHowToPlay,
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("CÓMO JUGAR", fontSize = 16.sp, color = Color(0xFF38BDF8))
        }
    }
}