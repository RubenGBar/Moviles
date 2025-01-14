package com.example.examenrecuperacion1.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface jugadorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: jugadorEntity)

    @Update
    suspend fun actualizar(jugador: jugadorEntity)

    @Query("SELECT COUNT(*) as jugadorRepetido from tablaJugadores where usuario = :nombre")
    suspend fun getExisteJugador(nombre: String): Int

    @Query("SELECT Max(id) FROM tablaJugadores")
    suspend fun getLastID(): Int

}