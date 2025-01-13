package com.example.repasorecuperacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun primera(navController: NavHostController) {

    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Column (

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)

    ) {

        Text("Menú Desplegable")

        Box {

            Button(
                onClick = { expanded = !expanded },
            ) {
                Text("Abrir Menú")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Pantalla 2") },
                    onClick = { navController.navigate("Pantalla2") }
                )

                DropdownMenuItem(
                    text = { Text(text = "Pantalla 3") },
                    onClick = { navController.navigate("Pantalla3") }
                )

                DropdownMenuItem(
                    text = { Text(text = "Pantalla 4") },
                    onClick = { navController.navigate("Pantalla4") }
                )
            }
        }

    } // Fin Column

}