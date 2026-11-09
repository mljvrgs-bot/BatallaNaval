package com.caos.batallanaval.viewmodel

import androidx.lifecycle.ViewModel
import com.caos.batallanaval.domain.engine.CpuOpponent
import com.caos.batallanaval.domain.engine.NavalEngine
import com.caos.batallanaval.domain.model.Board
import com.caos.batallanaval.domain.model.CellState
import com.caos.batallanaval.domain.model.Coordinate
import com.caos.batallanaval.domain.model.Orientation
import com.caos.batallanaval.domain.model.Ship
import com.caos.batallanaval.domain.model.ShipType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Alias de tipo para evitar conflictos de sintaxis con mapas anidados en StateFlow
typealias PlacedShipsMap = Map<ShipType, Ship>

class ShipPlacementViewModel(
    private val engine: NavalEngine = NavalEngine(),
    private val cpuOpponent: CpuOpponent = CpuOpponent()
) : ViewModel() {

    private val _board = MutableStateFlow(Board())
    val board: StateFlow<Board> = _board.asStateFlow()

    private val _selectedShipType = MutableStateFlow<ShipType?>(ShipType.CARRIER)
    val selectedShipType: StateFlow<ShipType?> = _selectedShipType.asStateFlow()

    private val _currentOrientation = MutableStateFlow(Orientation.HORIZONTAL)
    val currentOrientation: StateFlow<Orientation> = _currentOrientation.asStateFlow()

    // Usando el alias PlacedShipsMap, StateFlow recibe exactamente UN parámetro de tipo
    private val _placedShips = MutableStateFlow<PlacedShipsMap>(emptyMap())
    val placedShips: StateFlow<PlacedShipsMap> = _placedShips.asStateFlow()

    fun setOrientation(orientation: Orientation) {
        _currentOrientation.value = orientation
    }

    fun selectShipType(type: ShipType) {
        _selectedShipType.value = type
    }

    fun placeShip(start: Coordinate): Boolean {
        val type = _selectedShipType.value ?: return false
        val orientation = _currentOrientation.value

        val tempShip = Ship(id = type.name.lowercase(), type = type, orientation = orientation)
        if (!engine.validateShipPlacement(_board.value, tempShip, start)) {
            return false
        }

        val coords = engine.calculateCoordinates(start, type.size, orientation)
        val finalShip = tempShip.copy(positions = coords)

        val updatedGrid = _board.value.grid.toMutableMap()
        coords.forEach { c ->
            updatedGrid[c] = updatedGrid[c]!!.copy(state = CellState.SHIP, shipId = finalShip.id)
        }

        _board.value = _board.value.copy(grid = updatedGrid, ships = _board.value.ships + finalShip)
        _placedShips.value = _placedShips.value + (type to finalShip)

        val remaining = ShipType.entries.firstOrNull { !_placedShips.value.containsKey(it) }
        _selectedShipType.value = remaining

        return true
    }

    fun isPlacementComplete(): Boolean = _placedShips.value.size == 5

    fun generateCpuBoard(): Board = cpuOpponent.generateCpuBoard()
}