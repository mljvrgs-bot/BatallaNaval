package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.domain.model.Orientation
import com.caos.batallanaval.ui.components.BoardView
import com.caos.batallanaval.ui.components.ShipSelector
import com.caos.batallanaval.viewmodel.ShipPlacementViewModel

@Composable
fun ShipPlacementScreen(
    viewModel: ShipPlacementViewModel = remember { ShipPlacementViewModel() },
    onPlacementComplete: () -> Unit
) {
    val board by viewModel.board.collectAsState()
    val selectedType by viewModel.selectedShipType.collectAsState()
    val orientation by viewModel.currentOrientation.collectAsState()
    val placedShips by viewModel.placedShips.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DESPLIEGUE FLOTA", fontSize = 20.sp, color = Color(0xFF38BDF8))

        BoardView(
            board = board,
            hideShips = false,
            onCellClick = { viewModel.placeShip(it) }
        )

        ShipSelector(
            selectedType = selectedType,
            placedTypes = placedShips.keys,
            currentOrientation = orientation,
            onSelectType = { viewModel.selectShipType(it) },
            onToggleOrientation = {
                val next = if (orientation == Orientation.HORIZONTAL) Orientation.VERTICAL else Orientation.HORIZONTAL
                viewModel.setOrientation(next)
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onPlacementComplete,
            enabled = viewModel.isPlacementComplete(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONFIRMAR Y COMBATIR")
        }
    }
}