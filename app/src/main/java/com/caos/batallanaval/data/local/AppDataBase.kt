package com.caos.batallanaval.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.caos.batallanaval.data.local.dao.GameStateDao
import com.caos.batallanaval.data.local.entity.GameStateEntity

@Database(entities = [GameStateEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameStateDao(): GameStateDao
}