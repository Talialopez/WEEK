package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Contacto:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacto)

        val btContacto: Button = findViewById(R.id.confirmar_contacto)
        btContacto.setOnClickListener {
            val intent = Intent(this, ConfirmacionContacto::class.java)
            startActivity(intent)
        }
    }
}
