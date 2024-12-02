package com.example.cinemaexamen.basedatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: ClienteEntity): Long

    @Update
    suspend fun update (cliente: ClienteEntity)

    @Query("DELETE FROM tCliente")
    suspend fun deleteClientes()

    @Query("Select * FROM tCliente WHERE id = :idCliente")
    suspend fun getCliente(idCliente: Long): ClienteEntity?

    @Query("Select * From tCliente")
    suspend fun getAllClientes():List<ClienteEntity>

    @Query("SELECT COUNT(*) as numCliente FROM tCliente WHERE salaElegida == :idSala ")
    suspend fun getClientesEnSala(idSala: Int): Int

    @Query("SELECT COUNT(*) as numCliente FROM tCliente WHERE salaElegida == 0 ")
    suspend fun getClientesSinSala(): Int

    @Query("SELECT COUNT(*) as numCliente FROM tCliente WHERE palomitas == 1 and salaElegida == :idSala ")
    suspend fun getClientesConPalomitas(idSala: Int): Int

    @Query("SELECT COUNT(*) as cliente FROM tCliente WHERE palomitas == 1")
    suspend fun cuantosPalomitas(): Int
}