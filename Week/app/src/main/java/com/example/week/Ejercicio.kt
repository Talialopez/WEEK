package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio)

        val btCalendario: Button = findViewById(R.id.buttoncalendario)
        btCalendario.setOnClickListener {
            val intent = Intent(this, ConfirmarEjercicio::class.java)
            startActivity(intent)
        }

        val btSeleccionar: Button = findViewById(R.id.buttonmes)
        btSeleccionar.setOnClickListener {
            val intent = Intent(this, SeleccionarEjercicio::class.java)
            startActivity(intent)
        }
    }
}