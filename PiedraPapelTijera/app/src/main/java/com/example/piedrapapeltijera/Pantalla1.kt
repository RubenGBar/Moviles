package com.example.piedrapapeltijera

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun pantalla1(navController: NavHostController) {

    var valor by rememberSaveable { mutableStateOf("") }
    val acero = painterResource(R.drawable.acerogo)
    val planta = painterResource(R.drawable.plantago)
    val roca = painterResource(R.drawable.rocago)
    val interrogacion = painterResource(R.drawable.unkowquestion)
    val puntPc by rememberSaveable { mutableStateOf(0) }
    val puntJu by rememberSaveable { mutableStateOf(0) }

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
                    painter = interrogacion,
                    contentDescription = null
                )
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("PC")
                Image(
                    painter = interrogacion,
                    contentDescription = null
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
                    valor = "piedra"
                    navController.navigate("pantalla2/${valor}")
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
                    valor = "tijera"
                    navController.navigate("pantalla2/${valor}")
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
                    valor = "papel"
                    navController.navigate("pantalla2/${valor}")
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