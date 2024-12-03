package com.example.examenroom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.prepararexamen.BaseDatos.heroeEntity
import kotlinx.coroutines.launch

@Composable
fun crearHeroe(navController: NavHostController, id: String?) {

    var ultimoId by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        ultimoId = MainActivity.baseDatos.heroeDao().getLastID()
    }
    var heroe = heroeEntity(0, "", 0, "", "")
    var nombre by remember { mutableStateOf("") }
    var nivel by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var heroeAEditar: heroeEntity
    if (id != null) {
        if (id.toInt() != 0){
            LaunchedEffect(Unit) {
                heroeAEditar = MainActivity.baseDatos.heroeDao().getHeroePorID(id.toInt())
                nombre = heroeAEditar.nombre
                nivel = heroeAEditar.nivel.toString()
                tipo = heroeAEditar.tipo
                estado = heroeAEditar.estado
            }
        }
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(
            Modifier.height(30.dp)
        )
        Text(
            text = "Configuración del cine:",
            fontSize = 30.sp
        )
        Spacer(
            Modifier.height(60.dp)
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre:") },
            placeholder = { Text("Ej: Rodolfo") },
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = nivel,
            onValueChange = { nivel = it },
            label = { Text("Nivel") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            placeholder = { Text("Ej: 13 (mayor que 0)") },
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("Clase") },
            placeholder = { Text("Ej: Guerrero, Mago, Pícaro, etc.") },
            singleLine = true,
            modifier = Modifier.width(300.dp)
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = estado,
            onValueChange = { estado = it },
            label = { Text("Estado") },
            placeholder = { Text("Ej: Disponible o En Misión") },
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
                if (id != null) {
                    if (id.toInt() != 0){
                        heroe = heroeEntity(
                            id = id.toInt(),
                            nombre = nombre,
                            nivel = nivel.toInt(),
                            tipo = tipo,
                            estado = estado
                        )
                    }
                }else{
                    heroe = heroeEntity(
                        id = ultimoId + 1,
                        nombre = nombre,
                        nivel = nivel.toInt(),
                        tipo = tipo,
                        estado = estado
                    )
                }
                if (id != null) {
                    if (id.toInt() != 0){
                        MainActivity.coroutine.launch {
                            MainActivity.baseDatos.heroeDao().insertar(heroe)
                        }
                        navController.navigate("Pantalla2")
                    } else {
                        MainActivity.coroutine.launch {
                            MainActivity.baseDatos.heroeDao().insertar(heroe)
                        }
                        navController.navigate("Pantalla2")
                    }
                }
            }
        ) {
            Text("Guardar", textAlign = TextAlign.Center)
        }
    }
}