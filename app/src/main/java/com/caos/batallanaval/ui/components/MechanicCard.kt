package com.caos.batallanaval.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.caos.batallanaval.domain.model.SpecialMechanic

@Composable
fun MechanicCard(mechanic: SpecialMechanic) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(mechanic.type.displayName, color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(mechanic.type.description, color = Color(0xFF94A3B8), fontSize = 12.sp)
        }
    }
}