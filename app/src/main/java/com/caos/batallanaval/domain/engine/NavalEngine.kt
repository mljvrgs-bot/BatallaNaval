package com.caos.batallanaval.domain.engine

import com.caos.batallanaval.domain.model.*

sealed class AttackResult {
    data class Water(val coordinate: Coordinate) : AttackResult()
    data class Hit(val coordinate: Coordinate, val shipId: String) : AttackResult()
    data class Sunk(val coordinate: Coordinate, val ship: Ship) : AttackResult()
    data class Invalid(val reason: String) : AttackResult()
}

class NavalEngine {

    fun calculateCoordinates(start: Coordinate, size: Int, orientation: Orientation): List<Coordinate> {
        return (0 until size).map { i ->
            if (orientation == Orientation.HORIZONTAL) {
                Coordinate(start.row, start.col + i)
            } else {
                Coordinate(start.row + i, start.col)
            }
        }
    }

    fun validateShipPlacement(board: Board, ship: Ship, start: Coordinate): Boolean {
        val coords = calculateCoordinates(start, ship.type.size, ship.orientation)
        if (coords.any { it.row < 0 || it.row >= board.size || it.col < 0 || it.col >= board.size }) {
            return false
        }
        val occupied = board.ships.flatMap { it.positions }.toSet()
        return coords.none { occupied.contains(it) }
    }

    fun processAttack(targetBoard: Board, targetCoord: Coordinate): Pair<Board, AttackResult> {
        val cell = targetBoard.grid[targetCoord] ?: return targetBoard to AttackResult.Invalid("Coordenada fuera de límites")
        if (cell.state == CellState.WATER || cell.state == CellState.HIT || cell.state == CellState.SUNK_SHIP) {
            return targetBoard to AttackResult.Invalid("Casilla previamente atacada")
        }

        val targetShip = targetBoard.ships.find { it.positions.contains(targetCoord) }

        return if (targetShip == null) {
            val updatedGrid = targetBoard.grid.toMutableMap()
            updatedGrid[targetCoord] = cell.copy(state = CellState.WATER)
            targetBoard.copy(grid = updatedGrid) to AttackResult.Water(targetCoord)
        } else {
            targetShip.hits.add(targetCoord)
            val isSunk = targetShip.isSunk
            val updatedGrid = targetBoard.grid.toMutableMap()

            if (isSunk) {
                targetShip.positions.forEach { pos ->
                    updatedGrid[pos] = updatedGrid[pos]!!.copy(state = CellState.SUNK_SHIP)
                }
                targetBoard.copy(grid = updatedGrid) to AttackResult.Sunk(targetCoord, targetShip)
            } else {
                updatedGrid[targetCoord] = cell.copy(state = CellState.HIT)
                targetBoard.copy(grid = updatedGrid) to AttackResult.Hit(targetCoord, targetShip.id)
            }
        }
    }
}