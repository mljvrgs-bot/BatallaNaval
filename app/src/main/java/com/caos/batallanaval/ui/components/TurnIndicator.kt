package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TurnIndicator(isPlayerTurn: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isPlayerTurn) Color(0xFF0284C7) else Color(0xFFB91C1C))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isPlayerTurn) "TU TURNO - ATACA" else "TURNO ENEMIGO",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}