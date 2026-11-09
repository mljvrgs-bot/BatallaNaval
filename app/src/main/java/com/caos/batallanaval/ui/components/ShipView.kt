package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.domain.model.ShipType

@Composable
fun ShipView(type: ShipType, isSunk: Boolean = false) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .background(
                if (isSunk) Color(0xFF7F1D1D) else Color(0xFF1E293B),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${type.displayName} (${type.size})",
            color = if (isSunk) Color(0xFFFCA5A5) else Color.White,
            fontSize = 14.sp
        )
    }
}