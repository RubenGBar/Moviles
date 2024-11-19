package com.example.listacontactosparte2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.listacontactosparte2.ui.theme.ListaContactosParte2Theme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: ContactoDataBase
        lateinit var todos: List<ContactoEntity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(applicationContext,ContactoDataBase::class.java,"tasks-db").build()
        enableEdgeToEdge()
        setContent {
            runBlocking {
                launch{
                    todos = database.ContactoDao().getAll()
                }
            }
            val navController = rememberNavController()
            NavHost (
                navController = navController,
                startDestination = "PantallaInicio"
            ){
                composable("AgregarUsuario/{usuario}") { backStackEntry ->
                    aplicacion(
                        navController,
                        backStackEntry.arguments?.getString("usuario")
                    )
                }
                composable("PantallaInicio") {
                    bienvenida(
                        navController
                    )
                }
            }
        }
    }
}
