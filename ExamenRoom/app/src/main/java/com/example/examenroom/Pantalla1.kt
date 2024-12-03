package com.example.examenroom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prepararexamen.BaseDatos.heroeEntity
import com.example.prepararexamen.BaseDatos.misionEntity

@Composable
fun inicio(navController: NavHostController) {

    var heroe by remember {
        mutableStateOf(
            heroeEntity(
                id = 0,
                nombre = "",
                nivel = 0,
                tipo = "",
                estado = ""
            )
        )
    }

    var mision by remember {
        mutableStateOf(
            misionEntity(
                id = 0,
                titulo = "",
                descripcion = "",
                dificultad = "",
                puntos = 0
            )
        )
    }

    var heroesRegistrados by remember { mutableStateOf(0) }
    var misionesRegistradas by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        heroesRegistrados = MainActivity.baseDatos.heroeDao().getNumeroHeroes()
        misionesRegistradas = MainActivity.baseDatos.misionDao().getNumeroMisiones()
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            "Total de hores registrados: $heroesRegistrados"
        )

        Text(
            "Total de misiones registradas: $misionesRegistradas"
        )

        Spacer(Modifier.height(50.dp))

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .size(width = 200.dp, height = 60.dp)
                    .padding(10.dp),
                onClick = {
                    navController.navigate("Pantalla2")
                }
            ) {
                Text(
                    "Lista de Héroes"
                )
            }

            Button(
                modifier = Modifier
                    .size(width = 200.dp, height = 60.dp)
                    .padding(10.dp),
                onClick = {
                    navController.navigate("Pantalla4")
                }
            ) {
                Text(
                    "Lista de Misiones"
                )
            }
        }

    }

}