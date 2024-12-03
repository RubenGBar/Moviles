package com.example.prepararexamen.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaHeroe")
data class heroeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombre: String = "",
    var nivel: Int = 1,
    var tipo: String = "",
    var estado: String = "",
)
