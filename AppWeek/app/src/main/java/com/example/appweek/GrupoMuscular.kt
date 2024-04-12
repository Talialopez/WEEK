package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GrupoMuscular: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grupo_muscular)

        val btBrazos: Button = findViewById(R.id.btn_brazos)
        btBrazos.setOnClickListener {
            val intent = Intent(this, EnfoqueMuscular::class.java)
            startActivity(intent)
        }
    }
}