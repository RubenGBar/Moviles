package com.example.piedrapapeltijera

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun pantalla1(navController: NavHostController) {

    val acero = painterResource(R.drawable.acerogo)
    val planta = painterResource(R.drawable.plantago)
    val roca = painterResource(R.drawable.rocago)
    val interrogacion = painterResource(R.drawable.unkowquestion)
    var puntPc by rememberSaveable { mutableStateOf(0) }
    var puntJu by rememberSaveable { mutableStateOf(0) }
    var jugadaPc by rememberSaveable { mutableStateOf(0) }
    var jugadaJugador by rememberSaveable { mutableStateOf(0) }
    val tijera = painterResource(R.drawable.scizor)
    val piedra = painterResource(R.drawable.realgeodude)
    val papel = painterResource(R.drawable.kartana)
    val contexto = LocalContext.current
    var ganador by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Text("J1: $puntJu vs PC: $puntPc", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row (
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("J1")
                Image(
                    painter = when(jugadaJugador){
                        1 -> piedra
                        2 -> tijera
                        3 -> papel
                        else -> interrogacion
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("PC")
                Image(
                    painter = when(jugadaPc){
                        1 -> piedra
                        2 -> tijera
                        3 -> papel
                        else -> interrogacion
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    jugadaJugador = 1
                    jugadaPc = CalculaPc()
                    ganador = ganador(jugadaJugador, jugadaPc)

                    if(ganador.equals("PC") || ganador.equals("Jugador")){
                        Toast.makeText(contexto,"Ha ganado el $ganador", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(contexto,"No ha ganado $ganador", Toast.LENGTH_LONG).show()
                    }

                    if(ganador.equals("PC")){
                        puntPc += 1
                    }else if(ganador.equals("Jugador")){
                        puntJu += 1
                    }

                    if(puntJu >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }else if(puntPc >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }
                },
                content = {
                    // Specify the icon using the icon parameter
                    Image(painter = roca, contentDescription = null)
                    Spacer(modifier = Modifier.width(5.dp)) // Adjust spacing
                    Text("Piedra")
                }
            )

            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    jugadaJugador = 2
                    jugadaPc = CalculaPc()
                    ganador = ganador(jugadaJugador, jugadaPc)

                    if(ganador.equals("PC") || ganador.equals("Jugador")){
                        Toast.makeText(contexto,"Ha ganado el $ganador", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(contexto,"No ha ganado $ganador", Toast.LENGTH_LONG).show()
                    }

                    if(ganador.equals("PC")){
                        puntPc += 1
                    }else if(ganador.equals("Jugador")){
                        puntJu += 1
                    }

                    if(puntJu >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }else if(puntPc >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }
                },
                content = {
                    // Specify the icon using the icon parameter
                    Image(painter = acero, contentDescription = null)
                    Spacer(modifier = Modifier.width(5.dp)) // Adjust spacing
                    Text("Tijera")
                }
            )

            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    jugadaJugador = 3
                    jugadaPc = CalculaPc()
                    ganador = ganador(jugadaJugador, jugadaPc)

                    if(ganador.equals("PC") || ganador.equals("Jugador")){
                        Toast.makeText(contexto,"Ha ganado el $ganador", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(contexto,"No ha ganado $ganador", Toast.LENGTH_LONG).show()
                    }

                    if(ganador.equals("PC")){
                        puntPc += 1
                    }else if(ganador.equals("Jugador")){
                        puntJu += 1
                    }

                    if(puntJu >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }else if(puntPc >= 3){
                        navController.navigate("PantallaGanador/${ganador}")
                    }
                },
                content = {
                    // Specify the icon using the icon parameter
                    Image(painter = planta, contentDescription = null)
                    Spacer(modifier = Modifier.width(5.dp)) // Adjust spacing
                    Text("Papel")
                }
            )
        }

    }

}

fun CalculaPc(): Int {
    val random1 = (1..3).shuffled().last()
    return random1
}

fun ganador(jugadaJ: Int, jugadaPc: Int): String {

    var ganador  = ""

    if (jugadaJ == 1 && jugadaPc == 2 ||
        jugadaJ == 2 && jugadaPc == 3 ||
        jugadaJ == 3 && jugadaPc == 1){
        ganador = "PC"
    }else if (jugadaJ == 2 && jugadaPc == 1 ||
        jugadaJ == 3 && jugadaPc == 2 ||
        jugadaJ == 1 && jugadaPc == 3){
        ganador = "Jugador"
    }else {
        ganador = "Nadie"
    }

    return ganador
}