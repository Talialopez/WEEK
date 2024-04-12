package com.example.appweek

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionRegistro: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmacion_registro)

        iniciarTemporizador()
    }

    private fun iniciarTemporizador() {
        Handler().postDelayed({
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}