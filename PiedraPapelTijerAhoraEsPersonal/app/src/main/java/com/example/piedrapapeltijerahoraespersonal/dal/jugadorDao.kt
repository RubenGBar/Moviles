package com.example.piedrapapeltijerahoraespersonal.dal

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface jugadorDao {

    @Query("SELECT * FROM jugador_entity")
    suspend fun getAllJugadores(): MutableList <jugadorEntity>

    @Insert
    suspend fun addJugador(jugador: jugadorEntity): Long

    @Query("SELECT * FROM jugador_entity where id like :id")
    suspend fun getJugadorByNombre(id: Long): jugadorEntity

    @Update
    suspend fun updateJugador(jugador: jugadorEntity): Int

    @Delete
    suspend fun deleteJugador(jugador: jugadorEntity): Int

}