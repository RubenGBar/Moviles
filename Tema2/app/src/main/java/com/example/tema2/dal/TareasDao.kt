package com.example.tema2.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TareasDao {

    @Query("SELECT * FROM task_entity")
    suspend fun getAll(): List<TareasEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tasks: TareasEntity): Long

    @Update
    suspend fun actualizar(tarea: TareasEntity)

}