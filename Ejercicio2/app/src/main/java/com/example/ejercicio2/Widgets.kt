package com.example.ejercicio2

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text


@Composable
fun widgetsView(){

    var seleccionado by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row (
            Modifier.fillMaxSize().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Pulsa para que ocurra magia")

            Checkbox(
                checked = seleccionado,
                onCheckedChange = {seleccionado = true}
            )

            if(seleccionado){

                Button(
                    onClick = {

                    }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text(
                        text = "🔮Magia✨"
                    )
                }

            }

        }
    }

}


