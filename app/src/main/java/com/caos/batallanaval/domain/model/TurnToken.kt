package com.caos.batallanaval.domain.model

sealed class TurnToken(
    val id: String,
    val name: String,
    val description: String
) {
    object BasicAttack : TurnToken("basic_attack", "Ataque Estándar", "Ejecuta un disparo simple en el tablero del enemigo.")
}