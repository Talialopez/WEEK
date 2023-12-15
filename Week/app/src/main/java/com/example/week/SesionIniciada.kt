package com.example.week

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SesionIniciada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sesion_iniciada)

        val btMenu : ImageButton = findViewById(R.id.buttonmenu)
        btMenu.setOnClickListener{
            val intent = Intent(this, PoliticaPrivacidad::class.java)
            startActivity(intent)
        }

        val btContacto : ImageButton = findViewById(R.id.buttonretroceder)
        btContacto.setOnClickListener{
            val intent = Intent(this, Contacto::class.java)
            startActivity(intent)
        }

        val btAyuda : Button = findViewById(R.id.buttonayuda)
        btAyuda.setOnClickListener {
            val intent = Intent(this, AyudaActivity::class.java)
            startActivity(intent)
        }

        val btCalendario : Button = findViewById(R.id.buttoncalendario)
        btCalendario.setOnClickListener {
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }
    }
}
