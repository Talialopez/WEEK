package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Entrenamiento : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrenamiento)

        val btInicio: ImageButton = findViewById(R.id.botonAbajo1)
        btInicio.setOnClickListener {
            val intent = Intent(this, SesionIniciada::class.java)
            startActivity(intent)
        }

        val btEntrenamiento: ImageButton = findViewById(R.id.botonAbajo2)
        btEntrenamiento.setOnClickListener {
            val intent = Intent(this, Entrenamiento::class.java)
            startActivity(intent)
        }

        val btPerfil: ImageButton = findViewById(R.id.botonAbajo3)
        btPerfil.setOnClickListener {
            val intent = Intent(this, EditarPerfil::class.java)
            startActivity(intent)
        }

    }
}