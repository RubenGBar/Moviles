package com.example.examenmoviles

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
                startDestination = "sexo"

            ) {
                composable("sexo"){ datos(navController) }
                composable("altura/{nombre}/{sexo}"){ backStackEntry ->
                    pedirDatos(
                        navController,
                        backStackEntry.arguments?.getString("nombre"),
                        backStackEntry.arguments?.getString("sexo")
                    )
                }
                composable("resultado/{nombre}/{sexo}/{peso}/{altura}"){ navBackStackEntry ->
                    resultado(
                        navController,
                        navBackStackEntry.arguments?.getString("nombre"),
                        navBackStackEntry.arguments?.getString("sexo"),
                        navBackStackEntry.arguments?.getString("peso"),
                        navBackStackEntry.arguments?.getString("altura")
                    )
                }
            }

        }
    }
}

