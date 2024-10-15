package com.example.miprimeraapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var nombre: EditText
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nombre = findViewById<EditText>(R.id.campoUsuario)

        val boton = findViewById<Button>(R.id.acceso)

        boton.setOnClickListener {
            val nombreAString = nombre.text.toString()

            if(nombreAString.equals("Ruben")){
                setContentView(R.layout.bienvenida)
                var etiqueta = findViewById<TextView>(R.id.saludo)

                val botonVuelta = findViewById<Button>(R.id.volver)

                botonVuelta.setOnClickListener {
                    setContentView(R.layout.activity_main)
                }

                etiqueta.text = "Bienvenido " + nombre.text
                val toast = Toast.makeText(this, "Hola ${nombre.text}", Toast.LENGTH_LONG)
                toast.show()
            }

        }

        Log.d(":::Vida", "Acabo de crear la aplicacion")
    }

   /* override fun onStart() {
        super.onStart()
        Log.d(":::Vida", "Acabo de iniciar la aplicacion")
    }

    override fun onResume() {
        super.onResume()
        Log.d(":::Vida", "Aplicacion reactivada")
    }*/

    override fun onStop() {
        super.onStop()

        val toast = Toast.makeText(this, "Se ha cerrado la sesión de ${nombre.text}", Toast.LENGTH_LONG)
        toast.show()

       Log.d(":::Vida", "Aplicacion parada")
    }

    /*override fun onDestroy() {
        super.onDestroy()
        Log.d(":::Vida", "Aplicacion destruida")
    }*/

    override fun onRestart() {
        super.onRestart()

        val imagen = findViewById<ImageView>(R.id.pause)

        imagen.isVisible = false

        val toast = Toast.makeText(this, "Bienvenido de nuevo ${nombre.text}", Toast.LENGTH_LONG)
        toast.show()

        Log.d(":::Vida", "Aplicacion reiniciada")
    }

    override fun onPause() {
        super.onPause()

        val imagen = findViewById<ImageView>(R.id.pause)

        imagen.isVisible = true

        Log.d(":::Vida", "Aplicacion en pausa")
    }
}