package com.example.tema2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TareaDao {

    @Query("SELECT * FROM task_entity")
    fun getAll(): List<TareasEntity>

    @Query("SELECT * FROM task_entity WHERE id = :id")
    fun findById(id: Int): TareasEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tasks: List<TareasEntity>)

}