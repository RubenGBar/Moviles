package com.example.tema2.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tema2.MainActivity.Companion.database
import com.example.tema2.dal.TareasEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun lista(listaTareas: List<TareasEntity>, coroutineScope: CoroutineScope){
    LazyColumn {
        items(listaTareas){tarea ->
            filaTarea(tarea, coroutineScope)
        }
    }
}

@Composable
fun nuevaTarea(coroutineScope: CoroutineScope, listaTareas: SnapshotStateList<TareasEntity>) {
    var texto by remember { mutableStateOf("") }
    Row {
        TextField(
            value = texto,
            onValueChange = {
                texto = it
            },
            label = {
                Text(text = "Nueva Tarea")
            }
        )

        Button(
            onClick = {
                var tarea = TareasEntity()
                tarea.name = texto
                coroutineScope.launch {
                    database.tareaDao().insert(tarea)
                    listaTareas.add(tarea)
                    texto = ""
                }

            }
        ) {
            Text("Añadir")
        }
    }
}

@Composable
fun filaTarea(tarea: TareasEntity, coroutineScope: CoroutineScope){
    var checked by remember { mutableStateOf(tarea.isDone) }
    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                tarea.isDone = checked
                coroutineScope.launch {
                    database.tareaDao().actualizar(tarea)
                }
            }
        )
        Text(text = tarea.name)
    }
}

@Composable
fun miApp(){
    val coroutineScope = rememberCoroutineScope()
    var listaTareas = remember { mutableStateListOf<TareasEntity>() }
    LaunchedEffect(Unit) {
        listaTareas.clear()
        listaTareas.addAll(database.tareaDao().getAll())
    }
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(50.dp))
        nuevaTarea(coroutineScope, listaTareas)
        lista(listaTareas, coroutineScope)

    }

}