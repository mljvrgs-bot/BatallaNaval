package com.caos.batallanaval.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.caos.batallanaval.domain.model.Board
import com.caos.batallanaval.domain.model.CellState
import com.caos.batallanaval.domain.model.Coordinate

@Composable
fun BoardView(
    board: Board,
    hideShips: Boolean = false,
    onCellClick: (Coordinate) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(Color(0xFF0F172A))
            .border(2.dp, Color(0xFF1E293B))
    ) {
        for (r in 0 until board.size) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (c in 0 until board.size) {
                    val coord = Coordinate(r, c)
                    val cell = board.grid[coord]
                    val cellState = cell?.state ?: CellState.EMPTY

                    BoardCellView(
                        state = cellState,
                        hideShips = hideShips,
                        onClick = { onCellClick(coord) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}