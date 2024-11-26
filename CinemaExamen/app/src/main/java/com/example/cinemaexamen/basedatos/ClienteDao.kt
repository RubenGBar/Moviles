package com.example.cinemaexamen.basedatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: ClienteEntity): Long

    @Query("Select * From tCliente")
    suspend fun getAllClientes():List<ClienteEntity>

}