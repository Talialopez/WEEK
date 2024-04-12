package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CurlsBiceps: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.curls_biceps)

        val btConsejos: Button = findViewById(R.id.btn_consejos)
        btConsejos.setOnClickListener {
            val intent = Intent(this, Consejos::class.java)
            startActivity(intent)
        }

        val btEstadisticas: Button = findViewById(R.id.btn_estadisticas)
        btEstadisticas.setOnClickListener {
            val intent = Intent(this, Estadisticas::class.java)
            startActivity(intent)
        }
    }
}