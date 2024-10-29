package com.example.piedrapapeltijera

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
                startDestination = "pantalla1"
            ) {
                composable(route="Pantalla1") { pantalla1(navController) }
                composable("pantalla2/{valor}") { backStackEntry ->
                    pantalla2(
                        navController,
                        valor = backStackEntry.arguments?.getString("valor")
                    )
                }
            }
        }
    }
}

