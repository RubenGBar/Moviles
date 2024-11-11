package com.example.piedrapapeltijerahoraespersonal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.piedrapapeltijerahoraespersonal.dal.jugadorDatabase
import com.example.piedrapapeltijerahoraespersonal.dal.jugadorEntity

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: jugadorDatabase
        lateinit var todos: List<jugadorEntity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "loggin"
            ) {
                composable(route="Pantalla1/{usuario}") { backStackEntry ->
                    pantalla1(
                        navController,
                        backStackEntry.arguments?.getString("usuario")
                    )
                }
                composable("PantallaGanador/{usuario}") { backStackEntry ->
                    victoria(
                        navController,
                        backStackEntry.arguments?.getString("usuario"),
                        backStackEntry.arguments?.getString("ganador")
                    )
                }
                composable("pantallaInicio/{usuario}") { backStackEntry ->
                    loggin(
                        navController,
                        backStackEntry.arguments?.getString("usuario")
                    )
                }
            }
        }
    }
}
