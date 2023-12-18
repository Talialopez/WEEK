package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CrearEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_ejercicio)

        val btGuardar: Button = findViewById(R.id.continuar)
        btGuardar.setOnClickListener {
            val intent = Intent(this, ConfirmarEjercicio::class.java)
            startActivity(intent)
        }
    }
}