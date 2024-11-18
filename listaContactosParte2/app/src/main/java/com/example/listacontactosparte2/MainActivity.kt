package com.example.listacontactosparte2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactosparte2.ui.theme.ListaContactosParte2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaContactosParte2Theme {

                MaterialTheme{

                    ItemList(

                        itemContacto = listOf(

                            Contacto("Juan", "123456789", 0),
                            Contacto("Pepe", "999999999", 1),
                            Contacto("Luis", "2423523426", 0),
                            Contacto("Antonio", "54634654", 1),
                            Contacto("Joselu", "4235265454", 0),
                            Contacto("David", "3423552255", 1),
                            Contacto("Aitor", "25346252352", 0),
                            Contacto("Maria", "2525346463", 1),
                            Contacto("Daniel", "235235235", 0),
                            Contacto("Marta", "2352523525", 0)

                        )


                    )

                }

                Greeting(
                    name = "Android",
                    modifier = Modifier.fillMaxSize()
                )

            }
        }
    }
}


@Composable
fun ContactoView(contacto: Contacto) {
    var foto = R.drawable.hkmeme
    if(contacto.imagen == 1){
        foto = R.drawable.pedropixelado
    }
    Card(Modifier.fillMaxWidth()) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = foto),
                    contentDescription = "Foto contacto",
                    Modifier.height(100.dp)
                )
            }
            Column {
                Text(
                    text = contacto.nombre,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = contacto.tfno,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )}
        }
    }
}


@Composable
fun ItemList(itemContacto: List<Contacto>){

    LazyColumn {

        items(itemContacto){ itemContacto ->
            ContactoView(contacto = itemContacto)
        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
