package com.example.cinemaexamen.basedatos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConfiguracionDao {

    @Update
    suspend fun actualizar (configuracion: ConfiguracionEntity)

    @Query("Select * From tConfiguracion")
    suspend fun getAllSalas():List<ConfiguracionEntity>

}