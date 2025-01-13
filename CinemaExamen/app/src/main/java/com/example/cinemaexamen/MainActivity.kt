package com.example.cinemaexamen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.cinemaexamen.basedatos.CineDataBase
import com.example.cinemaexamen.ui.theme.CinemaExamenTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var database: CineDataBase
        lateinit var coroutine: CoroutineScope
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            val navController = rememberNavController()


            database = Room.databaseBuilder(
                this, CineDataBase::class.java, "cine-db"
            ).build()


            coroutine = rememberCoroutineScope()


            CinemaExamenTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(top = 60.dp),
                        navController = navController,
                        startDestination = "Pantalla1",

                        ) {
                        composable("Pantalla1") { inicio(navController) }
                        composable("Pantalla2") { lista(navController) }
                        composable("Pantalla3") { resumen(navController) }
                        composable("Pantalla4/{idSala}") { backStackEntry ->
                            var id = backStackEntry.arguments?.getString("idSala") ?: "0"
                            Log.d("IDFEO", "onCreate: $id")
                            PantallaDetalles(
                                idSala = id.toInt()
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = innerPadding.calculateTopPadding()),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Row(
                            modifier = Modifier
                                .height(60.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedButton(
                                shape = RectangleShape,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                onClick = {
                                    navController.navigate("Pantalla1")
                                }
                            ) {
                                Text("Configuración")
                            }

                            OutlinedButton(
                                shape = RectangleShape,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                onClick = {
                                    navController.navigate("Pantalla2")
                                }
                            ) {
                                Text("Salas")
                            }
                            OutlinedButton(
                                shape = RectangleShape,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                onClick = {
                                    navController.navigate("Pantalla3")
                                }
                            ) {
                                Text("Asistencia    ")
                            }
                        }
                    }
                }

            }
        }
    }
}

