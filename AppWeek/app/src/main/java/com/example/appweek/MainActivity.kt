package com.example.appweek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btRegistro: Button = findViewById(R.id.registro)
        btRegistro.setOnClickListener {
        val intent = Intent(this, Registro::class.java)
        startActivity(intent)
        }

        val btCuentaExistente: TextView = findViewById(R.id.texto_iniciar_sesion)
        btCuentaExistente.setOnClickListener{
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }
}