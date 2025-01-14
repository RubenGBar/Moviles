package com.example.examenrecuperacion1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun sorteo(navController: NavHostController, nombre: String?, apuesta1: String?, apuesta2: String?) {

    var idPartida by remember { mutableStateOf(0) }
//    LaunchedEffect(Unit) {
//        idPartida = MainActivity.baseDatos.partidaDao().getLastID()
//    }
    var resultado1 by remember { mutableStateOf(0) }
    var resultado2 by remember { mutableStateOf(0) }
    var boton1SeVe = true
    var boton2SeVe = true
    var boton3SeVe = false
    var puntuacion by remember { mutableStateOf(0) }

    Column (

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {

        Text(
            "Partida Nº${idPartida}",
            fontSize = 15.sp
        )
        Spacer(
            Modifier.height(10.dp)
        )
        Text(
            "Jugador: ${nombre}",
            fontSize = 15.sp
        )
        Spacer(
            Modifier.height(20.dp)
        )
        Row (

            horizontalArrangement = Arrangement.Center

        ) {

            Text(
                "Apuestas: ${apuesta1} y ${apuesta2}",
                fontSize = 25.sp
            )

        }
        Spacer(
            Modifier.height(10.dp)
        )
        Row (

            horizontalArrangement = Arrangement.Center

        ) {

            Text(
                "Resultados: ",
                fontSize = 45.sp
            )

            Column (

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(
                    "${resultado1}",
                    fontSize = 45.sp,
                )

                Button(
                    onClick = {
                        resultado1 = generaSorteo(0)
                        boton1SeVe = false
                    },
                    enabled = boton1SeVe
                ) {
                    Text(
                        "Generar"
                    )
                }

            } // Fin Column

            Column (

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                resultado2 = generaSorteo(resultado1)

                Text(
                    "${resultado2}",
                    fontSize = 45.sp
                )

                Button(
                    onClick = {
                        resultado1 = generaSorteo(0)
                        boton2SeVe = false
                    },
                    enabled = boton2SeVe
                ) {
                    Text(
                        "Generar"
                    )
                }

            } // Fin Column

        } // Fin Row
        Spacer(
            Modifier.height(20.dp)
        )
        if (apuesta1 != null && apuesta2 != null) {
            if(apuesta1.toInt() == resultado1 && apuesta2.toInt() == resultado2){
                puntuacion = 10
            }else if (apuesta1.toInt() == resultado2 && apuesta2.toInt() == resultado1){
                puntuacion = 5
            } else if (apuesta1.toInt() == resultado1 || apuesta2.toInt() == resultado2){
                puntuacion = 2
            } else if (apuesta1.toInt() == resultado1 || apuesta1.toInt() == resultado2 || apuesta2.toInt() == resultado1 || apuesta2.toInt() == resultado2) {
                puntuacion = 1
            } else {
                puntuacion = 0
            }
        }
        if(!boton1SeVe && !boton2SeVe){

            Button(
                onClick = {
                    navController.navigate("Pantalla4/${puntuacion}")
                },
                enabled = boton3SeVe
            ) {
                Text(
                    "Resultados"
                )
            }

        }
    }

}

fun generaSorteo(resultado1: Int): Int {
    var numeroADevolver = 0

    do {
        numeroADevolver = Random.nextInt(1, 10)
    } while (numeroADevolver != resultado1)

    return numeroADevolver
}