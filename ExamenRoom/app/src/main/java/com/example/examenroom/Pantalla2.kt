package com.example.examenroom

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prepararexamen.BaseDatos.heroeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun listaHeroes(navController: NavHostController) {

    var heroe by remember { mutableStateOf(heroeEntity(0, "", 0, "", "")) }
    var listaHeroe = remember { mutableStateListOf<heroeEntity>() }
    var numeroHeroes by remember { mutableStateOf(0) }
    var ultimoId by remember { mutableStateOf(0) }
    var id by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        ultimoId = MainActivity.baseDatos.heroeDao().getLastID()
        MainActivity.baseDatos.heroeDao().deleteHeroesPorID(heroe.id)
        numeroHeroes = MainActivity.baseDatos.heroeDao().getNumeroHeroes()
        if (numeroHeroes == 0){
            MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+1, "Ai'poon", 3, "Monje", "En Mision"))
            MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+2, "Garfang", 3, "Picaro", "Disponible"))
            MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+3, "Marrano", 5, "Fontanero", "Disponible"))
            MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+4, "Babuino", 7, "Brujo", "En Mision"))
            MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+5, "Kokun", 99, "Saiyan", "En Mision"))
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(20.dp))
        Text("Heroes")
        LaunchedEffect(Unit) {
            listaHeroe.clear()
            listaHeroe.addAll(MainActivity.baseDatos.heroeDao().getAllHeroes())
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(10.dp))
            Button(modifier = Modifier
                .size(width = 150.dp, height = 60.dp)
                .padding(10.dp),
                onClick = {
                    navController.navigate("Pantalla3/${id}")
                }
            ) {
                Text("Crear Heroe")
            }
            heroes(listaHeroe, MainActivity.coroutine, navController)

            Spacer(modifier = Modifier.height(16.dp))


        }

    }
}

@Composable
fun heroes(listaHeroe: List<heroeEntity>, coroutineScope: CoroutineScope, navController: NavHostController) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        items(listaHeroe){ heroe ->
            HeroeItem(heroe, coroutineScope, navController)
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HeroeItem(heroe: heroeEntity, coroutineScope: CoroutineScope, navController: NavHostController) {

    var color: Color by remember { mutableStateOf(Color.Red) }
    var id = heroe.id
    var numeroHeroes by remember { mutableStateOf(0) }
    var ultimoId by remember { mutableStateOf(0) }

    if (heroe.estado == "Disponible") {
        color = Color.Green
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(150.dp),
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = color // Color de la barra
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate("Pantalla3/${id}")
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Heroe: ${heroe.nombre}\n"
                            + "Nivel: ${heroe.nivel}\n"
                            + "Tipo: ${heroe.tipo}\n"
                            + "Estado: ${heroe.estado}\n",
                    textAlign = TextAlign.Center
                )
            }
        }
        Button(modifier = Modifier
            .size(width = 200.dp, height = 60.dp)
            .padding(10.dp),
            onClick = {
                MainActivity.coroutine.launch {
                    MainActivity.baseDatos.heroeDao().deleteHeroesPorID(heroe.id)
                    ultimoId = MainActivity.baseDatos.heroeDao().getLastID()
                    MainActivity.baseDatos.heroeDao().deleteHeroesPorID(heroe.id)
                    numeroHeroes = MainActivity.baseDatos.heroeDao().getNumeroHeroes()
                    if (numeroHeroes == 0){
                        MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+1, "Ai'poon", 3, "Monje", "En Mision"))
                        MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+2, "Garfang", 3, "Picaro", "Disponible"))
                        MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+3, "Marrano", 5, "Fontanero", "Disponible"))
                        MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+4, "Babuino", 7, "Brujo", "En Mision"))
                        MainActivity.baseDatos.heroeDao().insertar(heroeEntity(ultimoId+5, "Kokun", 99, "Saiyan", "En Mision"))
                    }

                }
                navController.navigate("Pantalla2")
            }
        ) {
            Text("Borrar Heroe")
        }
    }
}