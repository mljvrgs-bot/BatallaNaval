package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.domain.model.CellState

@Composable
fun BoardCellView(
    state: CellState,
    hideShips: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val displayColor = when (state) {
        CellState.EMPTY -> Color(0xFF1E293B)
        CellState.SHIP -> if (hideShips) Color(0xFF1E293B) else Color(0xFF3B82F6)
        CellState.WATER -> Color(0xFF0284C7)
        CellState.HIT -> Color(0xFFEF4444)
        CellState.SUNK_SHIP -> Color(0xFF7F1D1D)
    }

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(1.dp)
            .background(displayColor)
            .border(0.5.dp, Color(0xFF334155))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (state == CellState.WATER) {
            Text("•", color = Color.White, fontSize = 12.sp)
        } else if (state == CellState.HIT || state == CellState.SUNK_SHIP) {
            Text("✕", color = Color.White, fontSize = 12.sp)
        }
    }
}