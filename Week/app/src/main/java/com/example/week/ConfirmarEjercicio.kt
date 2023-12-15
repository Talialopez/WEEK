package com.example.week

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class ConfirmarEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmar_ejercicio)

        iniciarTemporizador()
    }
    private fun iniciarTemporizador() {
        Handler().postDelayed({
            val intent = Intent(this, Ejercicio::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}
