package com.example.prepararexamen.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface heroeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(hore: heroeEntity)

    @Query("SELECT COUNT(*) as numHeroes from tablaHeroe")
    suspend fun getNumeroHeroes(): Int

    @Query("DELETE FROM tablaHeroe")
    suspend fun deleteHeroes()

    @Query("DELETE FROM tablaHeroe WHERE id = :index")
    suspend fun deleteHeroesPorID(index: Int)

    @Query("SELECT * FROM tablaHeroe")
    suspend fun getAllHeroes(): List<heroeEntity>

    @Query("SELECT * FROM tablaHeroe where id = :index")
    suspend fun getHeroePorID(index: Int): heroeEntity

    @Query("SELECT Max(id) FROM tablaHeroe")
    suspend fun getLastID(): Int
}