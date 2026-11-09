package com.caos.batallanaval.viewmodel

import androidx.lifecycle.ViewModel
import com.caos.batallanaval.domain.mechanics.NewLifeMechanic
import com.caos.batallanaval.domain.model.Board
import com.caos.batallanaval.domain.model.Ship

class NewLifeViewModel(
    private val mechanic: NewLifeMechanic = NewLifeMechanic()
) : ViewModel() {

    fun resetOpponentBoard(board: Board): Board {
        return mechanic.resetOpponentBoard(board)
    }

    fun prepareRecoveredShip(ship: Ship): Ship {
        return mechanic.prepareRecoveredShip(ship)
    }
}