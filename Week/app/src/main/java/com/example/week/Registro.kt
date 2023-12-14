package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val btnConfirmacion : Button = findViewById(R.id.continuar)
        btnConfirmacion.setOnClickListener{
            val intent = Intent(this, ConfirmarRegistro::class.java)
            startActivity(intent)
        }

    }
}