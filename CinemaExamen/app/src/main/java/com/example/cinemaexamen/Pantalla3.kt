package com.example.cinemaexamen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cinemaexamen.basedatos.ConfiguracionEntity

@Composable
fun resumen(navController: NavHostController) {
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

    var numClientesSinSala by remember { mutableIntStateOf(0) }
    var genteConPalomitas by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        conf = MainActivity.database.ConfiguracionDao().getConfiguracion()!!
        numClientesSinSala = MainActivity.database.ClienteDao().getClientesSinSala()
        genteConPalomitas = MainActivity.database.ClienteDao().cuantosPalomitas()
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Detalles de Salas",
            fontSize = 30.sp
        )

        Text(text = "Gente sin sala: $numClientesSinSala")

        Text(text = "Gente con palomitas: $genteConPalomitas")

        Text(text = "Dinero Recaudado: ${genteConPalomitas * conf.precioPalomitas}€")

        LazyColumn {
            items(conf.numSala) { index ->
                CartaDetallesSala(index + 1, conf, numClientesSinSala)
            }
        }

    }
}

@Composable
fun CartaDetallesSala(index: Int, conf: ConfiguracionEntity, numClientes: Int) {
    var gente by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        gente = MainActivity.database.ClienteDao().getClientesEnSala(index)
    }

    val porCiento = (gente * 100) / conf.numAsientos

    Surface(
        tonalElevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Sala $index",
            )
            Text(
                text = "$gente / ${conf.numAsientos} ($porCiento%)",
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
    }
}