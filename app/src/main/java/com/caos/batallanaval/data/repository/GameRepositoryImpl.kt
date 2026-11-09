package com.caos.batallanaval.data.repository

import com.caos.batallanaval.data.local.dao.GameStateDao
import com.caos.batallanaval.data.local.entity.GameStateEntity
import com.caos.batallanaval.domain.model.GameState
import com.caos.batallanaval.domain.repository.GameRepository

class GameRepositoryImpl(
    private val dao: GameStateDao? = null
) : GameRepository {

    override suspend fun saveGameState(state: GameState) {
        dao?.saveGame(
            GameStateEntity(
                gameId = state.gameId,
                isLocal = state.isLocal,
                isPlayerTurn = state.isPlayerTurn,
                isGameOver = state.isGameOver,
                winnerId = state.winnerId
            )
        )
    }

    override suspend fun getGameState(gameId: String): GameState? {
        val entity = dao?.getGameById(gameId) ?: return null
        return GameState(
            gameId = entity.gameId,
            isLocal = entity.isLocal,
            isPlayerTurn = entity.isPlayerTurn,
            isGameOver = entity.isGameOver,
            winnerId = entity.winnerId
        )
    }
}