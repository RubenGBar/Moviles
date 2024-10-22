package com.example.examenmoviles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun resultado(
    navController: NavHostController,
    nombre: String?,
    sexo: String?,
    peso: String?,
    altura: String?
) {

    var alturaNum = altura?.toDouble()
    var pesoNum = peso?.toDouble()
    var IMC = CalcularIMC(alturaNum, pesoNum, sexo)

    Text("Bienvenido $nombre")

    if(IMC != null){

        if(IMC < 18.5){

            Text("Su IMC es: $IMC")
            Text("Usted tiene un peso bajo")

        }else if(IMC >= 18.5 && IMC < 24.9){

            Text("Su IMC es: $IMC")
            Text("Usted tiene un peso normal")

        }else if(IMC >= 24.9 && IMC < 29.9){

            Text("Su IMC es: $IMC")
            Text("Usted tiene un peso alto")

        }else if(IMC >= 130 ){

            Text("Su IMC es: $IMC")
            Text("Usted tiene un peso muy alto")

        }

    }

}

@Composable
fun CalcularIMC(pesoNum: Double?, alturaNum: Double?, sexo: String?): Int {

    var IMC by rememberSaveable { mutableStateOf(0) }

    if(sexo.equals("Hombre")){

        if (pesoNum != null) {
            if (alturaNum != null) {
                IMC = (((pesoNum/(alturaNum*alturaNum))*1)).toInt()
            }
        }

    }else if(sexo.equals("Mujer")){

        if (pesoNum != null) {
            if (alturaNum != null) {
                IMC = (((pesoNum/(alturaNum*alturaNum))*0.95)).toInt()
            }
        }

    }

    return IMC;

}