package com.example.examenrecuperacion1.BaseDatos

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [jugadorEntity::class, partidaEntity::class], version = 1)
abstract class bingoDataBase: RoomDatabase() {

    companion object {
        lateinit var coroutine: CoroutineScope
    }

    abstract fun jugadorDao(): jugadorDao

    abstract fun partidaDao(): partidaDao

}
