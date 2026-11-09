package com.caos.batallanaval.viewmodel

import androidx.lifecycle.ViewModel
import com.caos.batallanaval.domain.engine.CpuOpponent
import com.caos.batallanaval.domain.engine.NavalEngine
import com.caos.batallanaval.domain.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ShipPlacementViewModel(
    private val engine: NavalEngine = NavalEngine(),
    private val cpuOpponent: CpuOpponent = CpuOpponent()
) : ViewModel() {

    private val _board = MutableStateFlow(Board())
    val board: StateFlow<Board> = _board

    private val _selectedShipType = MutableStateFlow<ShipType?>(ShipType.CARRIER)
    val selectedShipType: StateFlow<ShipType?> = _selectedShipType

    private val _currentOrientation = MutableStateFlow(Orientation.HORIZONTAL)
    val currentOrientation: StateFlow<Orientation> = _currentOrientation

    private val _placedShips = MutableStateFlow>(emptyMap<ShipType, Ship>())
    val placedShips = _placedShips.asStateFlow()

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

        // Seleccionar automáticamente el siguiente barco no colocado
        val remaining = ShipType.entries.firstOrNull { !_placedShips.value.containsKey(it) }
        _selectedShipType.value = remaining

        return true
    }

    fun isPlacementComplete(): Boolean = _placedShips.value.size == 5

    fun generateCpuBoard(): Board = cpuOpponent.generateCpuBoard()
}