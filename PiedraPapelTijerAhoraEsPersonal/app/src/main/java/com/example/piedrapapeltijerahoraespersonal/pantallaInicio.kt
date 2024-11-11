package com.example.piedrapapeltijerahoraespersonal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun loggin(navController: NavHostController, string: String?) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Espacio para la imagen
        Spacer(modifier = Modifier.height(50.dp))

        // Imagen (puedes poner la tuya en el recurso drawable)
        Image(
            painter = painterResource(id = R.drawable.piedraaaaaaaaaaa),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 32.dp),
            alignment = Alignment.Center
        )

        // Campos de texto para el login
        var usuario by remember { mutableStateOf("") }

        // Email
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Botón de login
        Button(
            onClick = {
                navController.navigate("Pantalla1/${usuario}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar sesión")
        }
    }

}