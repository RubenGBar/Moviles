package com.example.navegacin

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun listaAnimales(){

    ItemList(
        zoo = listOf(
            Animal("Perro", "animal mamifero de 4 patas canino"),
            Animal("Caballo", "animal mamifero de 4 patas que la gente monta"),
            Animal("Gato", "animal mamifero de 4 patas felino"),
            Animal("Toro", "animal mamifero de 4 patas con cuernos"),
            Animal("Leon", "animal mamifero de 4 patas felino muy grande"),
            Animal("Girafa", "animal mamifero de 4 patas y cuello largo")
        )
    )

}

@Composable
fun ItemList(zoo: List<Animal>) {
    LazyColumn {

        items (zoo){
            zoo -> zooView(animal = zoo)
        }

    }
}

@Composable
fun zooView(animal: Animal){
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        Modifier.fillMaxSize().padding(8.dp).clickable { isExpanded = !isExpanded }
    ){
        Row(

            Modifier.fillMaxSize().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Crossfade(targetState = isExpanded, label = "") { expanded ->

                if(expanded){

                    Column {
                        Text(

                            text = animal.nombre + "",
                            Modifier.fillMaxSize()

                        )
                        Spacer(
                            Modifier.size(10.dp)
                        )
                        Text(

                            text = animal.description,
                            Modifier.fillMaxSize()

                        )

                    }
                }else{

                    Text(

                        text = animal.nombre,
                        Modifier.fillMaxSize()

                    )

                }

            }

        }
    }
}