package com.example.piedrapapeltijerahoraespersonal.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugador_entity")
data class jugadorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var nombre: String = "",
    var partidasJugadas: Int = 0,
    var partidasGanadas: Int = 0,
    var encuentrosGanados: Int = 0
)
