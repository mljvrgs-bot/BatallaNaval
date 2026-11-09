package com.caos.batallanaval.domain.model

enum class ShipType(val displayName: String, val size: Int) {
    CARRIER("Portaaviones", 5),
    BATTLESIP("Acorazado", 4),
    CRUISER("Crucero", 3),
    SUBMARINE("Submarino", 3),
    DESTROYS("Destructor", 2)
}

enum class Orientation {
    HORIZONTAL,
    VERTICAL
}

data class Ship(
    val id: String,
    val type: ShipType,
    val orientation: Orientation = Orientation.HORIZONTAL,
    val positions: List<Coordinate> = emptyList(),
    val hits: MutableSet<Coordinate> = mutableSetOf()
) {
    val isSunk: Boolean
        get() = positions.isNotEmpty() && hits.containsAll(positions)
}