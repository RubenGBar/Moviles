package com.example.prepararexamen.BaseDatos

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [heroeEntity::class, misionEntity::class, bonificacionEntity::class], version = 1)
abstract class mythoDataBase: RoomDatabase(){

    companion object {
        lateinit var coroutine: CoroutineScope
    }

    abstract fun heroeDao():heroeDao

    abstract fun misionDao(): misionDao

    abstract fun bonificacionDao(): bonificacionDao

}
