package com.caos.batallanaval.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caos.batallanaval.ui.components.BoardView
import com.caos.batallanaval.ui.components.PlayerInfoBar
import com.caos.batallanaval.ui.components.TurnIndicator
import com.caos.batallanaval.viewmodel.BattleViewModel

@Composable
fun BattleScreen(
    viewModel: BattleViewModel = remember { BattleViewModel() },
    onTriggerNewLife: () -> Unit,
    onGameOver: () -> Unit
) {
    val playerBoard by viewModel.playerBoard.collectAsState()
    val opponentBoard by viewModel.opponentBoard.collectAsState()
    val isPlayerTurn by viewModel.isPlayerTurn.collectAsState()
    val triggerNewLife by viewModel.triggerNewLifeEvent.collectAsState()
    val isGameOver by viewModel.isGameOver.collectAsState()

    LaunchedEffect(triggerNewLife) {
        if (triggerNewLife) {
            viewModel.consumeNewLifeEvent()
            onTriggerNewLife()
        }
    }

    LaunchedEffect(isGameOver) {
        if (isGameOver) {
            onGameOver()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090D16))
    ) {
        PlayerInfoBar(playerName = "Jugador 1", opponentName = "CPU")
        TurnIndicator(isPlayerTurn = isPlayerTurn)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("TABLERO DE ATAQUE (RIVAL)", color = Color(0xFFEF4444), fontSize = 12.sp)
            BoardView(
                board = opponentBoard,
                hideShips = true,
                onCellClick = { viewModel.attackOpponent(it) }
            )

            Text("TU TABLERO", color = Color(0xFF38BDF8), fontSize = 12.sp)
            BoardView(
                board = playerBoard,
                hideShips = false,
                onCellClick = { }
            )
        }
    }
}