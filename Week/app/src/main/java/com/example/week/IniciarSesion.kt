package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class IniciarSesion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion)

        val btIniciarSesion : Button = findViewById(R.id.buttoniniciarsesion)
        btIniciarSesion.setOnClickListener{
            val intent = Intent(this, SesionIniciada::class.java)
            startActivity(intent)
        }
    }
}