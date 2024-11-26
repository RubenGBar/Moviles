package com.example.cinemaexamen.basedatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tCliente")
data class ClienteEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var salaElegida:Int = 0,
    var palomitas:Int = 0,
)
