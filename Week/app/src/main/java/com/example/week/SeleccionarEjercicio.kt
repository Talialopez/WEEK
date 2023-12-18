package com.example.week

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SeleccionarEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccionar_ejercicio)

        val btflecha: ImageView = findViewById(R.id.botonflecha)
        btflecha.setOnClickListener {
            val intent = Intent(this, CurlsDeBiceps::class.java)
            startActivity(intent)
        }
    }
}