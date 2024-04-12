package com.example.week

import Entrenamiento
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)

        val btCalendario : Button = findViewById(R.id.botoneditarperfil)
        btCalendario.setOnClickListener {
            val intent = Intent(this, EditarPerfil::class.java)
            startActivity(intent)
        }

        val btConfiguracion : ImageView = findViewById(R.id.botonConfiguracion)
        btConfiguracion.setOnClickListener {
            val intent = Intent(this, Configuracion::class.java)
            startActivity(intent)
        }

        val btInicio: ImageButton = findViewById(R.id.botonAbajo1)
        btInicio.setOnClickListener {
            val intent = Intent(this, SesionIniciada::class.java)
            startActivity(intent)
        }

        val btEntrenamiento: ImageButton = findViewById(R.id.botonAbajo2)
        btEntrenamiento.setOnClickListener {
            val intent = Intent(this, Entrenamiento::class.java)
            startActivity(intent)
        }

        val btPerfil: ImageButton = findViewById(R.id.botonAbajo3)
        btPerfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        val btFormulario: Button = findViewById(R.id.formulario)
        btFormulario.setOnClickListener {
            val intent = Intent(this, Formulario::class.java)
            startActivity(intent)
        }
    }
}