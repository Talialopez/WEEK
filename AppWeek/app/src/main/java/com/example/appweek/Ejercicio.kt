package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio)

        val btCrearEjercicio: Button = findViewById(R.id.btn_crear_ejercicio)
        btCrearEjercicio.setOnClickListener {
            val intent = Intent(this, CrearEjercicio::class.java)
            startActivity(intent)
        }

        val btEjercicios: Button = findViewById(R.id.btn_seleccionar_ejercicio)
        btEjercicios.setOnClickListener{
            val i = Intent(this, SeleccionarEjercicio::class.java)
            startActivity(i)
        }
    }
}