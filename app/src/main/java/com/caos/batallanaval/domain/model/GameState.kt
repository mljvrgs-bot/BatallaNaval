package com.caos.batallanaval.domain.model

data class GameState(
    val gameId: String = "",
    val isLocal: Boolean = true,
    val playerBoard: Board = Board(),
    val opponentBoard: Board = Board(),
    val isPlayerTurn: Boolean = true,
    val selectedMechanics: List<SpecialMechanic> = emptyList(),
    val lastSunkShipPlayer: Ship? = null,
    val isGameOver: Boolean = false,
    val winnerId: String? = null
)