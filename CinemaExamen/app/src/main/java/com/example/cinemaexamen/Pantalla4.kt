package com.example.cinemaexamen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinemaexamen.basedatos.ConfiguracionEntity

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PantallaDetalles(idSala: Int) {
    var conf by remember {
        mutableStateOf(
            ConfiguracionEntity(
                id = 0,
                numSala = 0,
                numAsientos = 0,
                precioPalomitas = 0f
            )
        )
    }
    var numAsientosOcupados by remember { mutableStateOf(0) }
    var cuantoPalomitas by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        conf = MainActivity.database.ConfiguracionDao().getConfiguracion()!!
        numAsientosOcupados=MainActivity.database.ClienteDao().getClientesEnSala(idSala)
        cuantoPalomitas=MainActivity.database.ClienteDao().getClientesConPalomitas(idSala)
    }
    Column (

    ){
        Text(
            text = "Sala nº $idSala",
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Numero de asientos: ${conf.numAsientos}",
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Numero de asientos ocupados: $numAsientosOcupados",
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Numero de personas con palomitas en la sala: $cuantoPalomitas",
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "Dinero recaudado palomitas en sala: ${cuantoPalomitas * conf.precioPalomitas}€",
            modifier = Modifier.padding(10.dp)
        )
    }
}
