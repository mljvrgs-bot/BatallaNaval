package com.caos.batallanaval.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.caos.batallanaval.data.local.entity.GameStateEntity

@Dao
interface GameStateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGame(game: GameStateEntity)

    @Query("SELECT * FROM game_state WHERE gameId = :id")
    suspend fun getGameById(id: String): GameStateEntity?
}