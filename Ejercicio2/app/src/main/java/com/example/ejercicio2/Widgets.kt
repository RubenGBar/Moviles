package com.example.ejercicio2

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun widgetsView(){

    var seleccionado by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var esVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        AnimatedVisibility(esVisible) {
            Column (
                Modifier.padding(bottom = 5.dp)
            ) {
                Row (
                    Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text)
                }

                Spacer(Modifier.size(5.dp))

                Row (
                    Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = text,
                        onValueChange = {text = it},
                        label = {Text("Illo escribe algo: ")}
                    )
                }
            }
        }

        Row (
            Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Pulsa para que ocurra magia")

            Checkbox(
                checked = seleccionado,
                onCheckedChange = {seleccionado = it}
            )

        }

        Row (
            Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if(seleccionado){

                Button(
                    onClick = {

                        if(esVisible){
                            esVisible = false
                        }else {
                            esVisible = true
                        }

                    }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                ) {
                    Text(
                        text = "🔮Magia✨"
                    )
                }

            }
        }

    }

}


