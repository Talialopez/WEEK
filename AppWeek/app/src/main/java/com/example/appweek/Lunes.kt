package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Lunes: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lunes)

        val btAgregarEntrenamiento: Button = findViewById(R.id.agregar_entrenamiento)
        btAgregarEntrenamiento.setOnClickListener {
            val intent = Intent(this, GrupoMuscular::class.java)
            startActivity(intent)
        }
    }
}