package com.example.piedrapapeltijerahoraespersonal.dal

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface jugadorDao {

    @Query("SELECT * FROM jugador_entity")
    suspend fun getAllJugadores(): MutableList <jugadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(jugador: jugadorEntity): Long

    @Query("SELECT * FROM jugador_entity where nombre = :nombre LIMIT 1")
    suspend fun getJugadorByNombre(username: String): jugadorEntity?

    @Update
    suspend fun updateJugador(jugador: jugadorEntity): Int

}