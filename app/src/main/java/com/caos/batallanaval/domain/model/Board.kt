package com.caos.batallanaval.domain.model

enum class CellState {
    EMPTY,
    SHIP,
    WATER,
    HIT,
    SUNK_SHIP
}

data class Cell(
    val coordinate: Coordinate,
    val state: CellState = CellState.EMPTY,
    val shipId: String? = null
)

data class Board(
    val size: Int = 10,
    val grid: Map<Coordinate, Cell> = initialGrid(size),
    val ships: List<Ship> = emptyList()
) {
    companion object {
        fun initialGrid(size: Int): Map<Coordinate, Cell> {
            val map = mutableMapOf<Coordinate, Cell>()
            for (r in 0 until size) {
                for (c in 0 until size) {
                    val coord = Coordinate(r, c)
                    map[coord] = Cell(coordinate = coord)
                }
            }
            return map
        }
    }
}