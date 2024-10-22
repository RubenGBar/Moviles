package com.example.examenmoviles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun datos(navController: NavHostController) {

    var nombre by rememberSaveable { mutableStateOf("") }
    var sexo by rememberSaveable { mutableStateOf("") }

    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("Nombre: ") }
        )

        Row (

            Modifier.width(350.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {

            Button(
                onClick = {
                    sexo = "Hombre"
                    navController.navigate("altura/{$nombre}/{$sexo}")
                }
            ) {
                Text("Hombre")
            }

            Button(
                onClick = {
                    sexo = "Mujer"
                    navController.navigate("altura/{$nombre}/{$sexo}")
                }
            ) {
                Text("Mujer")
            }

        }

    }

}