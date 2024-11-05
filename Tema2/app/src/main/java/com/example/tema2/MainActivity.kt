package com.example.tema2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.room.Room
import com.example.tema2.dal.TareasDatabase
import com.example.tema2.dal.TareasEntity
import com.example.tema2.ui.themes.ListaTareasTheme
import com.example.tema2.ui.views.miApp
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: TareasDatabase
        lateinit var todos: List<TareasEntity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(applicationContext,TareasDatabase::class.java,"tasks-db").build()
        enableEdgeToEdge()
        setContent {
            runBlocking {
                launch{
                    todos = database.tareaDao().getAll()
                }
            }
            enableEdgeToEdge()
            setContent {
                ListaTareasTheme {
                    miApp()
                }
            }
        }
    }
}

