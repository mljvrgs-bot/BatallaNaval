package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.domain.model.TurnToken

@Composable
fun TokenView(token: TurnToken) {
    Text(
        text = "Ficha: ${token.name}",
        color = Color(0xFFFDE047),
        fontSize = 12.sp,
        modifier = Modifier
            .background(Color(0xFF334155), shape = RoundedCornerShape(4.dp))
            .padding(6.dp)
    )
}