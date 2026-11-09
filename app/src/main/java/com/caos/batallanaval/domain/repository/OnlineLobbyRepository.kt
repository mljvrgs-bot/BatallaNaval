package com.caos.batallanaval.domain.repository

interface OnlineLobbyRepository {
    suspend fun createRoom(): String
    suspend fun joinRoom(code: String): Boolean
}