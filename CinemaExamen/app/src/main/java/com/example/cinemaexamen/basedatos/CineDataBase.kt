package com.example.cinemaexamen.basedatos

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ConfiguracionEntity::class, ClienteEntity::class], version = 1)
abstract class CineDataBase: RoomDatabase() {

    companion object {
        lateinit var coroutine: CoroutineScope
    }

    abstract fun ConfiguracionDao(): ConfiguracionDao

    abstract fun ClienteDao(): ClienteDao

}
