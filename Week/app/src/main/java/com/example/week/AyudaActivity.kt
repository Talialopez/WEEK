package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AyudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ayuda)

        val btAyuda : Button = findViewById(R.id.buttoncalendario)
        btAyuda.setOnClickListener{
            val intent = Intent(this, ObjetivoFuerza::class.java)
            startActivity(intent)
        }
    }
}