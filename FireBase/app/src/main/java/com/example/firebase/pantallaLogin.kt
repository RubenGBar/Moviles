package com.example.firebase

import android.R.attr.password
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lint.kotlin.metadata.Visibility
import androidx.navigation.NavHostController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


@Composable
fun login(navController: NavHostController) {
    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(value = false) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido",
                fontSize = 40.sp
            )
        }

        Row (
            horizontalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
                placeholder = { Text("Usuario")},
                singleLine = true,
                shape = RoundedCornerShape(percent = 20),
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 16.dp)
            )

        }

        Row (
            horizontalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                placeholder = { Text("Contraseña")},
                singleLine = true,
                shape = RoundedCornerShape(percent = 20),
                visualTransformation = if (showPassword) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()

                },
                trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.ojocerrado),
                                contentDescription = "hide_password"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { showPassword = true }) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(R.drawable.ojoabierto),
                                contentDescription = "hide_password"
                            )
                        }
                    }
                },
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 16.dp),
            )

        }

        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
                    mAuth.signInWithEmailAndPassword(usuario, contrasena)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navController.navigate("loginExitoso/${usuario}")
                            } else {
                                navController.navigate("loginErroneo")
                            }
                        }
                },
            ) {
                Text("Continuar")
            }
        }

    }

}
