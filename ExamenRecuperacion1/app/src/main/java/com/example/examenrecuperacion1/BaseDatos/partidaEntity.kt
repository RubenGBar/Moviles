package com.example.examenrecuperacion1.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablaPartidas")
data class partidaEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var idJugador: Int = 0,
    var apuesta1: Int = 0,
    var apuesta2: Int = 0,
    var bola1: Int = 0,
    var bola2: Int = 0,
    var premio: Int = 0,
)
