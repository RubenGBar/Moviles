package com.example.cinemaexamen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.cinemaexamen.basedatos.CineDataBase
import com.example.cinemaexamen.basedatos.ClienteEntity
import com.example.cinemaexamen.basedatos.ConfiguracionEntity
import com.example.cinemaexamen.ui.theme.CinemaExamenTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: CineDataBase
        lateinit var cliente: List<ClienteEntity>
        lateinit var configuracion: List<ConfiguracionEntity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(applicationContext,CineDataBase::class.java,"cine-db").build()
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            runBlocking {
                launch{
                    cliente = database.ClienteDao().getAllClientes()
                    configuracion = database.ConfiguracionDao().getAllSalas()
                }
            }
            CinemaExamenTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(top = 60.dp),
                        navController = navController,
                        startDestination = "Panatalla1"
                    ) {
                        composable("Pantalla1") {
                            inicio(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("Panatalla2") {
                            lista(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        composable("Pantalla3") {
                            resumen(
                                modifier = Modifier.fillMaxSize()
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
                                .fillMaxWidth()
                                .background(Color.Blue),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate("Pantalla1")
                                }
                            ) {
                                Text("Pantalla 1")
                            }

                            Button(
                                onClick = {
                                    navController.navigate("Pantalla2")
                                }
                            ) {
                                Text("Pantalla 2")
                            }

                            Button(
                                onClick = {
                                    navController.navigate("Pantalla3")
                                }
                            ) {
                                Text("Pantalla 3")
                            }
                        }
                    }
                }            }
        }
    }
}
