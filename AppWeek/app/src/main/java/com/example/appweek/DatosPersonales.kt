package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DatosPersonales:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_personales)

        val btDatosPersonales: Button = findViewById(R.id.guardar_datos_personales)
        btDatosPersonales.setOnClickListener {
            val intent = Intent(this, SesionIniciada::class.java)
            startActivity(intent)
        }
    }
}