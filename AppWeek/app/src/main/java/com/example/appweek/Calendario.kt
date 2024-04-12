package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Calendario: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendario)

        val btCrearCalendario: Button = findViewById(R.id.btn_crear_calendario)
        btCrearCalendario.setOnClickListener {
            val intent = Intent(this, CrearCalendario::class.java)
            startActivity(intent)
        }
    }
}