package com.example.examenroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.examenroom.ui.theme.ExamenRoomTheme
import com.example.prepararexamen.BaseDatos.mythoDataBase
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {

    companion object{
        lateinit var baseDatos: mythoDataBase
        lateinit var coroutine: CoroutineScope
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            baseDatos = Room.databaseBuilder(this, mythoDataBase::class.java,
                "mythoB-db").build()

            coroutine = rememberCoroutineScope()

            ExamenRoomTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Pantalla1",

                    ) {
                    composable("Pantalla1") { inicio(navController) }
                    composable("Pantalla2") { listaHeroes(navController) }
                    composable("Pantalla3/{idHeroe}") { backStackEnrty ->
                        crearHeroe(
                            navController,
                            backStackEnrty.arguments?.getString("idHeroe")
                        )
                    }
                    composable("Pantalla4") { listaMisiones(navController) }
                    composable("Pantalla5") { crearMision(navController) }
                }
            }
        }
    }
}

