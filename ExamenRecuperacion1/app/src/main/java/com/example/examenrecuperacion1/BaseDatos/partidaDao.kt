package com.example.examenrecuperacion1.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface partidaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(partida: partidaEntity)

    @Update
    suspend fun actualizar(partida: partidaEntity)

    @Query("SELECT Max(id) FROM tablaPartidas")
    suspend fun getLastID(): Int

    @Query("SELECT COUNT(idJugador) as aparicionesJugador FROM tablaPartidas WHERE idJugador = :jugadorABuscar")
    suspend fun numeroPartidasJugadas(jugadorABuscar: String): Int

    @Query("SELECT SUM(premio) FROM tablaPartidas WHERE idJugador = :jugadorABuscar")
    suspend fun getPuntuacionTotalPorJugador(jugadorABuscar: String): Int
}