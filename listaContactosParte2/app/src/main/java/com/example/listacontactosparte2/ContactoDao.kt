package com.example.listacontactosparte2
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactoDao {
    @Query("SELECT * FROM Contactos WHERE nombre = :nombre LIMIT 1")
    suspend fun getScoreByUsername(nombre: String): ContactoEntity?

    @Query("SELECT * FROM Contactos")
    suspend fun getAll():List<ContactoEntity>

    @Query("SELECT * FROM Contactos WHERE nombre = :nombre LIMIT 1")
    suspend fun getJugador(nombre: String): ContactoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: ContactoEntity): Long

    @Update
    suspend fun actualizar (jugador: ContactoEntity)
}