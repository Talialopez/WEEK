package com.example.week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val btLogin : Button = findViewById(R.id.botonLogin)
        btLogin.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        val btIniciarSesion : Button = findViewById(R.id.botonLogin2)
        btIniciarSesion.setOnClickListener{
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }
}