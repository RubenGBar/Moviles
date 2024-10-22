package com.example.examenmoviles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun pedirDatos(navController: NavHostController, nombre: String?, sexo: String?) {

    var peso by rememberSaveable { mutableStateOf("") }
    var altura by rememberSaveable { mutableStateOf("") }

    Column (

        modifier = Modifier
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        TextField(
            value = peso,
            onValueChange = {peso = it},
            label = { Text("Peso: ") }
        )

        Spacer(Modifier.height(10.dp))

        Text(text = "Altura:")

        Button(
            onClick = {
                altura = 1.50.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,50m")
        }

        Button(
            onClick = {
                altura = 1.60.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,60m")
        }

        Button(
            onClick = {
                altura = 1.70.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,70m")
        }

        Button(
            onClick = {
                altura = 1.80.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,80m")
        }

        Button(
            onClick = {
                altura = 1.90.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,90m")
        }

        Button(
            onClick = {
                altura = 1.90.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("1,90m")
        }

        Button(
            onClick = {
                altura = 2.00.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("2,00m")
        }

        Button(
            onClick = {
                altura = 2.10.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("2,10m")
        }

        Button(
            onClick = {
                altura = 2.20.toString()
                navController.navigate("resultado/{$nombre}/{$sexo}/{$peso}/{$altura}")
            }
        ) {
            Text("2,20m")
        }

    }

}