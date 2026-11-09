package com.caos.batallanaval.domain.repository

import com.caos.batallanaval.domain.model.GameState

interface GameRepository {
    suspend fun saveGameState(state: GameState)
    suspend fun getGameState(gameId: String): GameState?
}