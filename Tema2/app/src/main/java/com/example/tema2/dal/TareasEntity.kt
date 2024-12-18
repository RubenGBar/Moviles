package com.example.tema2.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_entity")
data class TareasEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L, // Id de la tarea
    var name:String = "", // Nombre de la tarea
    var isDone:Boolean = false // Booleano que indica si la tarea está hecha o no
)
