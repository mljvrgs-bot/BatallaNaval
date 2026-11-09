package com.caos.batallanaval.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameResultCard(winner: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text("RESULTADO FINAL", color = Color(0xFF38BDF8), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("Ganador: $winner", color = Color.White, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
        }
    }
}