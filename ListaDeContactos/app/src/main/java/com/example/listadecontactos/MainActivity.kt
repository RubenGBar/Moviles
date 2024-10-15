package com.example.listadecontactos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val contactos = listOf(
            Contacto("Juan", "123456789", 1),
            Contacto("Pepe", "999999999", 1),
            Contacto("Luis", "2423523426", 0),
            Contacto("Antonio", "54634654", 1),
            Contacto("Joselu", "4235265454", 0),
            Contacto("David", "3423552255", 1),
            Contacto("Aitor", "25346252352", 0),
            Contacto("Maria", "2525346463", 0),
            Contacto("Daniel", "235235235", 1),
            Contacto("Marta", "2352523525", 0)
        )
        val adapter = ContactosAdapter(contactos)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.contenedorDeVista)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}