package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ayuda: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ayuda)

        val btHipertrofia: Button = findViewById(R.id.Hipertrofia)
        btHipertrofia.setOnClickListener {
            val intent = Intent(this, ObjetivoHipertrofia::class.java)
            startActivity(intent)
        }
    }
}