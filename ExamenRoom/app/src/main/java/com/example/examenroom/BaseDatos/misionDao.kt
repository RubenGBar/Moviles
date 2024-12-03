package com.example.prepararexamen.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface misionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(mision: misionEntity)

    @Update
    suspend fun actualizar(mision: misionEntity)

    @Query("SELECT COUNT(*) as numMisiones from tablaMision")
    suspend fun getNumeroMisiones(): Int

    @Query("DELETE FROM tablaMision")
    suspend fun deleteMision()

    @Query("SELECT * FROM tablaMision")
    suspend fun getAllMisiones(): List<misionEntity>

    @Query("SELECT * FROM tablaMision where id = :index")
    suspend fun getMisionPorID(index: Int): misionEntity

}