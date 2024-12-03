package com.example.prepararexamen.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaMision")
data class misionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var titulo: String = "",
    var descripcion: String = "",
    var dificultad: String = "",
    var puntos: Int = 0,
)
