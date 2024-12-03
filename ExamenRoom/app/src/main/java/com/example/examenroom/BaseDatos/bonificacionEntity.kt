package com.example.prepararexamen.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaBonificacion")
data class bonificacionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    // No sé como usar las foreign key porque no se han explicado
    var idHeroe: Int = 0,
    var idMision: Int = 0,
    var conseguid: Boolean = false,
    var fecha: String = "",
)
