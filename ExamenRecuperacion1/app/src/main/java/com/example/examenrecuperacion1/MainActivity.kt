package com.example.examenrecuperacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.examenrecuperacion1.BaseDatos.bingoDataBase
import com.example.examenrecuperacion1.ui.theme.ExamenRecuperacion1Theme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {

    companion object{
        lateinit var baseDatos: bingoDataBase
        lateinit var coroutine: CoroutineScope
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            baseDatos = Room.databaseBuilder(this, bingoDataBase::class.java, "bingo-db").build()

            coroutine = rememberCoroutineScope()

            ExamenRecuperacion1Theme {

                NavHost(
                    navController = navController,
                    startDestination = "Pantalla1",
                ){
                    composable("Pantalla1") { identificar(navController) }
                    composable("Pantalla2/{nombre}") { backStackEntry ->
                        eleccion(
                            navController,
                            backStackEntry.arguments?.getString("nombre")
                        ) }
                    composable("Pantalla3/{nombre}/{apuesta1}/{apuesta2}") { backStackEntry ->
                        sorteo(
                            navController,
                            backStackEntry.arguments?.getString("nombre"),
                            backStackEntry.arguments?.getString("apuesta1"),
                            backStackEntry.arguments?.getString("apuesta2")
                        )
                    }
                    composable("Pantalla4/{resultado}") { backStackEntry ->
                        resultado(
                            navController,
                            backStackEntry.arguments?.getString("resultado")
                        )
                    }
                }

            }

        }
    }
}

