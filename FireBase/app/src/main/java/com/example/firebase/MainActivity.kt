package com.example.firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost (
                navController = navController,
                startDestination = "PantallaLogin"
            ){
                composable("pantallaLogin") {
                    login(
                        navController
                    )
                }
                composable("loginExitoso") { backStackEntry ->
                    exito(
                        navController,
                        backStackEntry.arguments?.getString("usuario")
                    )
                }
            }
        }
    }
}