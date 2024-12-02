package com.example.cinemaexamen.basedatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConfiguracionDao {

    @Insert
    suspend fun insertar (configuracion: ConfiguracionEntity)

    @Update
    suspend fun update (configuracion: ConfiguracionEntity)

    @Query("Select * From tConfiguracion")
    suspend fun getAllConfiguraciones():List<ConfiguracionEntity>

    @Query("Select * FROM tConfiguracion WHERE id = 1")
    suspend fun  getConfiguracion(): ConfiguracionEntity?

    @Query("SELECT id FROM tConfiguracion ORDER BY id DESC LIMIT 1")
    suspend fun getLastConfiguracion() : Long

}