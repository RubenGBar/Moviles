package com.example.prepararexamen.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface bonificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(bonificacion: bonificacionEntity)

    @Update
    suspend fun actualizar(bonificacion: bonificacionEntity)

}