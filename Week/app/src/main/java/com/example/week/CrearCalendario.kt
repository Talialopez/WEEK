package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CrearCalendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_calendario)

        val btCalendario : Button = findViewById(R.id.buttoncalendario)
        btCalendario.setOnClickListener {
            val intent = Intent(this, Lunes::class.java)
            startActivity(intent)
        }
    }
}