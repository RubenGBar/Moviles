package com.example.cinemaexamen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cinemaexamen.basedatos.ConfiguracionEntity
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun inicio(navController: NavHostController) {

    var numSalas by remember { mutableStateOf("0") }
    var numAsientos by remember { mutableStateOf("0") }
    var precioPalomitas by remember { mutableStateOf("0") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
            value = numSalas,
            onValueChange = { numSalas = it },
            label = { Text("Numero de salas:") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            placeholder = { Text("Ej: 8") },
            singleLine = true,
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = numAsientos,
            onValueChange = { numAsientos = it },
            label = { Text("Numero de asientos") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            placeholder = { Text("Ej: 16") },
            singleLine = true,
        )
        Spacer(
            Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = precioPalomitas,
            onValueChange = { precioPalomitas = it },
            label = { Text("Precio palomitas") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            placeholder = { Text("Ej: 3") },
            singleLine = true,
        )
        Spacer(
            Modifier.height(50.dp)
        )
        Button(

            modifier = Modifier
                .size(width = 150.dp, height = 60.dp),
            onClick = {
                var configuracion = ConfiguracionEntity(
                    numSala = numSalas.toInt(),
                    numAsientos = numAsientos.toInt(),
                    precioPalomitas = precioPalomitas.toFloat()
                )

                MainActivity.coroutine.launch {
                    MainActivity.database.ConfiguracionDao().insertar(configuracion)
                }

                MainActivity.coroutine.launch {
                    navController.navigate("Pantalla2")
                }
            }
        ) {
            Text("Guardar", textAlign = TextAlign.Center)
        }
    }
}

