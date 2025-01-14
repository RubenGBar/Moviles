package com.example.examenrecuperacion1.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaJugadores")
data class jugadorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var usuario: String = "",
)
