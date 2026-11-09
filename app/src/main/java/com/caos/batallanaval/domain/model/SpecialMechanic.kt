package com.caos.batallanaval.domain.model

enum class SpecialMechanicType(
    val displayName: String,
    val description: String
) {
    NEW_LIFE("Nueva Vida", "Permite continuar la partida recuperando el último barco destruido.")
}

data class SpecialMechanic(
    val type: SpecialMechanicType,
    val isAvailable: Boolean = true,
    val isUsed: Boolean = false
)