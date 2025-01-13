package com.example.repasorecuperacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "Pantalla1"
            ){
                composable("Pantalla1"){ primera(navController) }
                composable("Pantalla2"){ segunda(navController) }
                composable("Pantalla3"){ tercera(navController) }
                composable("Pantalla4"){ cuarta(navController) }
            }

        }
    }
}
