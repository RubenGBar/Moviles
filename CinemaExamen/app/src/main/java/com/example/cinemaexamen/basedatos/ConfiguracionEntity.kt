package com.example.cinemaexamen.basedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tConfiguracion")
data class ConfiguracionEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var numSala:Int = 0,
    var numAsientos:Int = 0,
    var precioPalomitas:Float = 0f,
)
