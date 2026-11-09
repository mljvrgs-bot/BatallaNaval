package com.caos.batallanaval.domain.engine

import com.caos.batallanaval.domain.model.*
import kotlin.random.Random

class CpuOpponent(private val engine: NavalEngine = NavalEngine()) {

    fun generateCpuBoard(): Board {
        var board = Board()
        val types = listOf(
            ShipType.CARRIER,
            ShipType.BATTLESIP,
            ShipType.CRUISER,
            ShipType.SUBMARINE,
            ShipType.DESTROYS
        )

        types.forEachIndexed { index, type ->
            var placed = false
            while (!placed) {
                val orientation = if (Random.nextBoolean()) Orientation.HORIZONTAL else Orientation.VERTICAL
                val row = Random.nextInt(0, 10)
                val col = Random.nextInt(0, 10)
                val start = Coordinate(row, col)

                val tempShip = Ship(id = "cpu_ship_$index", type = type, orientation = orientation)
                if (engine.validateShipPlacement(board, tempShip, start)) {
                    val coords = engine.calculateCoordinates(start, type.size, orientation)
                    val placedShip = tempShip.copy(positions = coords)

                    val updatedGrid = board.grid.toMutableMap()
                    coords.forEach { c ->
                        updatedGrid[c] = updatedGrid[c]!!.copy(state = CellState.SHIP, shipId = placedShip.id)
                    }

                    board = board.copy(
                        grid = updatedGrid,
                        ships = board.ships + placedShip
                    )
                    placed = true
                }
            }
        }
        return board
    }

    fun getRandomAttackCoordinate(playerBoard: Board): Coordinate {
        val availableCoords = playerBoard.grid.filterValues {
            it.state == CellState.EMPTY || it.state == CellState.SHIP
        }.keys.toList()

        return availableCoords[Random.nextInt(availableCoords.size)]
    }
}