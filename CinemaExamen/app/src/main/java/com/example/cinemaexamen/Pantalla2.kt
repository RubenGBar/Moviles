package com.example.cinemaexamen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cinemaexamen.basedatos.ClienteEntity
import com.example.cinemaexamen.basedatos.ConfiguracionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
@Composable
fun lista(navController: NavHostController, idConfig: String?) {

    val coroutineScope = rememberCoroutineScope()
    var configuracion by remember { mutableStateOf(ConfiguracionEntity(0, 0, 0, 0f)) }
    var enabled by remember { mutableStateOf(true) }
    var mensaje by remember { mutableStateOf("Esperando inicio...") } // Estado para el mensaje

    LaunchedEffect(enabled) {
        var numClientes = 0
        if (enabled) {
            mensaje = "Insertando clientes, por favor espere..."
            while (numClientes < 100) {
                delay(1000)
                numClientes += entraCliente(configuracion.numSala)
                mensaje = "Se han insertado $numClientes clientes"
            }
            mensaje = "Inserción completada: $numClientes clientes."
        } else {
            enabled = false
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Salas")
        LaunchedEffect(Unit) {
            MainActivity.database.ClienteDao().deleteClientes()
            configuracion = MainActivity.database.ConfiguracionDao().getConfiguracion(idConfig?.toLong() ?: 0)!!
        }
        salas(configuracion, coroutineScope)

        Spacer(modifier = Modifier.height(16.dp))
        Text(mensaje) // Muestra el mensaje actual
    }
}

@Composable
fun salas(configuracion: ConfiguracionEntity?, coroutineScope: CoroutineScope) {
    LazyColumn {
        if (configuracion != null) {
            items(configuracion.numSala) { index ->
                SalaItem(index = index + 1, configuracion, coroutineScope)
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SalaItem(index: Int, conf: ConfiguracionEntity, coroutineScope: CoroutineScope) {
    var color: Color by remember { mutableStateOf(Color.Blue) }
    var enabled by remember { mutableStateOf(true) }
    LaunchedEffect(index, conf) {
        while (enabled) {
            val clientes = MainActivity.database.ClienteDao().getClientesEnSala(index)
            val porCiento = if (conf.numAsientos > 0) (clientes * 100) / conf.numAsientos else 0

            color = when {
                porCiento >= 90 -> Color.Red
                porCiento >= 66 -> Color.Yellow
                else -> Color.Green
            }
            delay(1000)
        }
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
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = color // Color de la barra
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Sala $index",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

suspend fun entraCliente(numSalas: Int): Int {
    val numClientes = Random.nextInt(1, 3)
    for (i in 1..numClientes) {
        val salaElegida = Random.nextInt(1, numSalas + 1)
        val cliente = ClienteEntity(salaElegida = salaElegida, palomitas = 0)
        MainActivity.database.ClienteDao().insertar(cliente)
    }
    return numClientes
}