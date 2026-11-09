package com.caos.batallanaval.domain.model

sealed class Joker(
    val id: String,
    val name: String,
    val description: String
) {
    // Interfaz extensible para modificadores de partida
}