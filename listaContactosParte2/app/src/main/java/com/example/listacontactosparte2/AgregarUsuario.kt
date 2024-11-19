package com.example.listacontactosparte2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.listacontactosparte2.MainActivity.Companion.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun lista(listaContactos: List<ContactoEntity>, coroutineScope: CoroutineScope){
    LazyColumn {
        items(listaContactos){contacto ->
            filaTarea(contacto, coroutineScope)
        }
    }
}

@Composable
fun nuevaTarea(coroutineScope: CoroutineScope, listaTareas: SnapshotStateList<ContactoEntity>) {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var numFoto = elegirFoto()

    Row (
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Añadir contacto",
            fontSize = 25.sp
        )
    }

    Spacer(Modifier.height(5.dp))

    Row (
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            label = {
                Text(text = "Nombre")
            }
        )
    }

    Row (
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = {
                Text("Telefono")
            }
        )
    }

    Spacer(Modifier.height(5.dp))

    Row (
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                var contacto = ContactoEntity()
                contacto.nombre = nombre
                contacto.telefono = telefono.toInt()
                contacto.imagen = when(numFoto) {
                    1 -> "corvi"
                    2 -> "hkmeme"
                    3 -> "isaac"
                    4 -> "mujerusu"
                    5 -> "pedropixelado"
                    else -> "unkow"
                }
                coroutineScope.launch {
                    database.ContactoDao().insertar(contacto)
                    listaTareas.add(contacto)
                    nombre = ""
                    telefono = ""
                    numFoto = 0
                }

            }
        ) {
            Text("Añadir")
        }
    }

}

@Composable
fun filaTarea(contacto: ContactoEntity, coroutineScope: CoroutineScope){
    Row {
        Column {
            Image(
                painter = when(contacto.imagen){
                    "corvi" -> painterResource(R.drawable.corvi)
                    "hkmeme" -> painterResource(R.drawable.hkmeme)
                    "isaac" -> painterResource(R.drawable.isaac)
                    "mujerusu" -> painterResource(R.drawable.mujerusu)
                    "pedropixelado" -> painterResource(R.drawable.pedropixelado)
                    else -> painterResource(R.drawable.unkow)
                },
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
        }
        Column {
            Row {
                Text(text = contacto.nombre)
            }
            Row {
                Text(text = contacto.telefono.toString())
            }
        }
    }
}

@Composable
fun aplicacion(navController: NavHostController, usuario: String?) {
    val coroutineScope = rememberCoroutineScope()
    var listaTareas = remember { mutableStateListOf<ContactoEntity>() }
    LaunchedEffect(Unit) {
        listaTareas.clear()
        listaTareas.addAll(database.ContactoDao().getAll())
    }
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido $usuario",
                fontSize = 40.sp
            )
        }
        Spacer(Modifier.height(50.dp))
        nuevaTarea(coroutineScope, listaTareas)
        lista(listaTareas, coroutineScope)

    }

}

fun elegirFoto(): Int {
    val random1 = (1..5).shuffled().last()
    return random1
}