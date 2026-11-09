package com.caos.batallanaval.domain.mechanics

import com.caos.batallanaval.domain.model.Board
import com.caos.batallanaval.domain.model.Ship

class NewLifeMechanic {

    fun canActivate(remainingShipsCount: Int, isMechanicAvailable: Boolean): Boolean {
        return remainingShipsCount == 0 && isMechanicAvailable
    }

    fun resetOpponentBoard(opponentBoard: Board): Board {
        return Board(size = opponentBoard.size)
    }

    fun prepareRecoveredShip(lastSunkShip: Ship): Ship {
        return lastSunkShip.copy(
            positions = emptyList(),
            hits = mutableSetOf()
        )
    }
}