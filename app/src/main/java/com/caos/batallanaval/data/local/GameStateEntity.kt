package com.caos.batallanaval.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_state")
data class GameStateEntity(
    @PrimaryKey val gameId: String,
    val isLocal: Boolean,
    val isPlayerTurn: Boolean,
    val isGameOver: Boolean,
    val winnerId: String?
)