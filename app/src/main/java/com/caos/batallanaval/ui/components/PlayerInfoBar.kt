package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayerInfoBar(playerName: String, opponentName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F172A))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = playerName, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = "VS", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = opponentName, color = Color(0xFFEF4444), fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}