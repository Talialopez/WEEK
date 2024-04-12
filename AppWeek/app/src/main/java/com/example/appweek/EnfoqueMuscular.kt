package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EnfoqueMuscular:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enfoque_muscular)

        val btBiceps: Button = findViewById(R.id.btn_biceps)
        btBiceps.setOnClickListener {
            val intent = Intent(this, Ejercicio::class.java)
            startActivity(intent)
        }
    }
}