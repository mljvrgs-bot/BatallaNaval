package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameModeScreen(
    onSelectLocal: () -> Unit,
    onSelectOnline: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("MODO DE JUEGO", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onSelectLocal,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("LOCAL (VS CPU)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSelectOnline,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0369A1)),
            modifier = Modifier.fillMaxWidth().height(56.dp)
        ) {
            Text("ONLINE (MULTIJUGADOR)")
        }
    }
}