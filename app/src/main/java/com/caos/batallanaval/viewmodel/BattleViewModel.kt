package com.caos.batallanaval.viewmodel

import androidx.lifecycle.ViewModel
import com.caos.batallanaval.domain.engine.AttackResult
import com.caos.batallanaval.domain.engine.CpuOpponent
import com.caos.batallanaval.domain.engine.NavalEngine
import com.caos.batallanaval.domain.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BattleViewModel(
    private val engine: NavalEngine = NavalEngine(),
    private val cpuOpponent: CpuOpponent = CpuOpponent()
) : ViewModel() {

    private val _playerBoard = MutableStateFlow(Board())
    val playerBoard: StateFlow<Board> = _playerBoard

    private val _opponentBoard = MutableStateFlow(Board())
    val opponentBoard: StateFlow<Board> = _opponentBoard

    private val _isPlayerTurn = MutableStateFlow(true)
    val isPlayerTurn: StateFlow<Boolean> = _isPlayerTurn

    private val _lastSunkShip = MutableStateFlow<Ship?>(null)
    val lastSunkShip: StateFlow<Ship?> = _lastSunkShip

    private val _hasNewLifeAvailable = MutableStateFlow(true)
    val hasNewLifeAvailable: StateFlow<Boolean> = _hasNewLifeAvailable

    private val _triggerNewLifeEvent = MutableStateFlow(false)
    val triggerNewLifeEvent: StateFlow<Boolean> = _triggerNewLifeEvent

    private val _isGameOver = MutableStateFlow(false)
    val isGameOver: StateFlow<Boolean> = _isGameOver

    private val _winner = MutableStateFlow<String?>(null)
    val winner: StateFlow<String?> = _winner

    fun initMatch(playerBoard: Board, cpuBoard: Board) {
        _playerBoard.value = playerBoard
        _opponentBoard.value = cpuBoard
    }

    fun attackOpponent(coord: Coordinate) {
        if (!_isPlayerTurn.value || _isGameOver.value) return

        val (updatedBoard, result) = engine.processAttack(_opponentBoard.value, coord)
        if (result is AttackResult.Invalid) return

        _opponentBoard.value = updatedBoard

        if (_opponentBoard.value.ships.all { it.isSunk }) {
            _isGameOver.value = true
            _winner.value = "Jugador 1"
            return
        }

        _isPlayerTurn.value = false
        executeCpuTurn()
    }

    private fun executeCpuTurn() {
        if (_isGameOver.value) return

        val targetCoord = cpuOpponent.getRandomAttackCoordinate(_playerBoard.value)
        val (updatedBoard, result) = engine.processAttack(_playerBoard.value, targetCoord)
        _playerBoard.value = updatedBoard

        if (result is AttackResult.Sunk) {
            _lastSunkShip.value = result.ship
        }

        val remainingShips = _playerBoard.value.ships.count { !it.isSunk }
        if (remainingShips == 0) {
            if (_hasNewLifeAvailable.value) {
                _triggerNewLifeEvent.value = true
            } else {
                _isGameOver.value = true
                _winner.value = "CPU"
            }
            return
        }

        _isPlayerTurn.value = true
    }

    fun consumeNewLifeEvent() {
        _triggerNewLifeEvent.value = false
        _hasNewLifeAvailable.value = false
    }
}