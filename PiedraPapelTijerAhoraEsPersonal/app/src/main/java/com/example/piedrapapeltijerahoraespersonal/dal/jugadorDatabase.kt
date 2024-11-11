package com.example.piedrapapeltijerahoraespersonal.dal

import androidx.room.Database

@Database(entities = [jugadorEntity:: class], version = 1)
abstract class jugadorDatabase {
    abstract fun jugadorDao(): jugadorDao
}