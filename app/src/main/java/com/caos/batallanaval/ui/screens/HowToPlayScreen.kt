package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HowToPlayScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Manual de Batalla", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
        Spacer(modifier = Modifier.height(16.dp))

        Text("1. Tablero y Barcos", fontWeight = FontWeight.Bold, color = Color.White)
        Text("Ubica tus 5 barcos en la cuadrícula de 10x10 sin salirte ni superponerlos.", color = Color(0xFF94A3B8))

        Spacer(modifier = Modifier.height(12.dp))
        Text("2. Combate por Turnos", fontWeight = FontWeight.Bold, color = Color.White)
        Text("Selecciona una casilla del tablero oponente para disparar.", color = Color(0xFF94A3B8))

        Spacer(modifier = Modifier.height(12.dp))
        Text("3. Mecánica Nueva Vida", fontWeight = FontWeight.Bold, color = Color.White)
        Text("Si te destruyen tu último barco, podrás restaurar el tablero rival y volver a posicionar esa nave.", color = Color(0xFF94A3B8))

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}