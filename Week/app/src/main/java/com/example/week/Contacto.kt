package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Contacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacto)

        val btEnviar : Button = findViewById(R.id.continuar)
        btEnviar.setOnClickListener{
            val intent = Intent(this, ConfirmarContacto::class.java)
            startActivity(intent)
        }
    }
}