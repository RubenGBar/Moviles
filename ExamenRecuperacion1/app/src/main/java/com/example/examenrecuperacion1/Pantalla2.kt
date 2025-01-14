package com.example.examenrecuperacion1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun eleccion(navController: NavHostController, nombre: String?) {

    var partidasJugadas by remember { mutableStateOf(0) }
    var puntuacion by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        partidasJugadas = MainActivity.baseDatos.partidaDao().numeroPartidasJugadas(nombre.toString())
        puntuacion = MainActivity.baseDatos.partidaDao().getPuntuacionTotalPorJugador(nombre.toString())
    }
    var apuesta1 by remember { mutableStateOf("") }
    var apuesta2 by remember { mutableStateOf("") }

    Column (

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {

        Text(
            "Bienvenido ${nombre} \nal Mini Bingo",
            fontSize = 30.sp
        )
        Spacer(
            Modifier.height(10.dp)
        )
        Text(
            "Su puntuación total es de: ${puntuacion} punto/s",
            fontSize = 20.sp
        )
        Spacer(
            Modifier.height(30.dp)
        )
        Text(
            "Haga sus apuestas entre 1 a 9 porfavor"
        )
        Spacer(
            Modifier.height(10.dp)
        )
        OutlinedTextField(
            value = apuesta1,
            onValueChange = { apuesta1 = it },
            label = { Text("Apuesta 1:") },
            placeholder = { Text("Ej: 3") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            Modifier.height(10.dp)
        )
        OutlinedTextField(
            value = apuesta2,
            onValueChange = { apuesta2 = it },
            label = { Text("Apuesta 2:") },
            placeholder = { Text("Ej: 4") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            Modifier.height(20.dp)
        )
        Button(
            modifier = Modifier
                .size(width = 150.dp, height = 60.dp),
            onClick = {
                navController.navigate("Pantalla3/${nombre}/${apuesta1}/${apuesta2}")
            }
        ) {
            Text("Jugar")
        }
    }

}