package com.example.examenrecuperacion1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.examenrecuperacion1.BaseDatos.jugadorEntity
import kotlinx.coroutines.launch

@Composable
fun identificar(navController: NavHostController) {

    var ultimoId by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        ultimoId = MainActivity.baseDatos.jugadorDao().getLastID()
    }
    var existeJugador by remember { mutableStateOf(0) }
    var nombre by remember { mutableStateOf("") }
    var jugador = jugadorEntity(0, "")

    Column (

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {
        Spacer(
            Modifier.height(20.dp)
        )
        Text(
            text = "BIENVENIDO AL MINI BINGO",
            fontSize = 30.sp
        )
        Spacer(
            Modifier.height(60.dp)
        )
        Text(
            text = "Identifiquese"
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre:") },
            placeholder = { Text("Ej: Juan") },
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(
            modifier = Modifier
                .size(width = 150.dp, height = 60.dp),
            onClick = {
                MainActivity.coroutine.launch {
                    existeJugador = MainActivity.baseDatos.jugadorDao().getExisteJugador(nombre)
                }
                if(existeJugador == 0){
                    jugador = jugadorEntity(
                        id = ultimoId + 1,
                        usuario = nombre
                    )
                    MainActivity.coroutine.launch {
                        MainActivity.baseDatos.jugadorDao().insertar(jugador)
                    }
                    navController.navigate("Pantalla2/${nombre}")
                }else {
                    // TODO: Toast mostrando mensaje de que no se puede añadir el usuario
                }
            }
        ) {
            Text("Hacer Apuesta", textAlign = TextAlign.Center)
        }
    }

}